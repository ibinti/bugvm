/*
 * Copyright (C) 2012 RoboVM AB
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/gpl-2.0.html>.
 */
package com.bugvm.compiler;

import static com.bugvm.compiler.Functions.*;
import static com.bugvm.compiler.Mangler.*;

import java.util.ArrayList;
import java.util.Arrays;

import com.bugvm.compiler.clazz.Clazz;
import com.bugvm.compiler.config.Config;
import com.bugvm.compiler.config.OS;
import com.bugvm.compiler.llvm.*;
import com.bugvm.compiler.llvm.Bitcast;
import com.bugvm.compiler.llvm.Br;
import com.bugvm.compiler.llvm.FloatingPointConstant;
import com.bugvm.compiler.llvm.FloatingPointType;
import com.bugvm.compiler.llvm.Function;
import com.bugvm.compiler.llvm.FunctionRef;
import com.bugvm.compiler.llvm.FunctionType;
import com.bugvm.compiler.llvm.Global;
import com.bugvm.compiler.llvm.Icmp;
import com.bugvm.compiler.llvm.IntegerConstant;
import com.bugvm.compiler.llvm.IntegerType;
import com.bugvm.compiler.llvm.Label;
import com.bugvm.compiler.llvm.NullConstant;
import com.bugvm.compiler.llvm.PointerType;
import com.bugvm.compiler.llvm.Ret;
import com.bugvm.compiler.llvm.Unreachable;
import com.bugvm.compiler.llvm.Value;
import com.bugvm.compiler.llvm.Variable;

import soot.SootMethod;

/**
 * @author niklas
 *
 */
public class NativeMethodCompiler extends AbstractMethodCompiler {
    public static final String UNSATISFIED_LINK_ERROR = "%s.%s%s";

    public NativeMethodCompiler(Config config) {
        super(config);
    }

    protected Function doCompile(ModuleBuilder moduleBuilder, SootMethod method) {
        Function fn = createMethodFunction(method);
        moduleBuilder.addFunction(fn);

        Value env = fn.getParameterRef(0);
        
        ArrayList<Value> args = new ArrayList<Value>(Arrays.asList(fn.getParameterRefs()));
        if (method.isStatic()) {
            // Add the current class as second parameter
            FunctionRef ldcFn = FunctionBuilder.ldcInternal(sootMethod.getDeclaringClass()).ref();
            Value clazz = call(fn, ldcFn, env);
            args.add(1, clazz);
        }
        
        Functions.pushNativeFrame(fn);
        FunctionRef targetFn = createNative(moduleBuilder, method);
        Value result = call(fn, targetFn, args);
        Functions.popNativeFrame(fn);
        call(fn, Functions.BC_THROW_IF_EXCEPTION_OCCURRED, env);
        fn.add(new Ret(result));
        
        return fn;
    }
    
    private boolean isLongNativeFunctionNameRequired(SootMethod method) {
        int nativeCount = 0;
        for (SootMethod m : this.sootClass.getMethods()) {
            if (m.isNative() && m.getName().equals(method.getName())) {
                nativeCount++;
            }
        }
        return nativeCount > 1;
    }

    private FunctionRef createNative(ModuleBuilder mb, SootMethod method) {
        String targetInternalName = Types.getInternalName(method.getDeclaringClass());
        String methodName = method.getName();
        String methodDesc = Types.getDescriptor(method);
        FunctionType nativeFunctionType = Types.getNativeFunctionType(methodDesc, method.isStatic());
        
        Clazz target = config.getClazzes().load(targetInternalName);
        String shortName = mangleNativeMethod(targetInternalName, methodName);
        String longName = mangleNativeMethod(targetInternalName, methodName, methodDesc);
        if (target.isInBootClasspath() || !config.isUseDynamicJni() || config.getOs() == OS.ios) {
            /*
             * Static JNI. Create weak stub functions with the same names as the
             * expected JNI functions (long and short names). These will be
             * discarded by the linker if proper functions are available at link
             * time. The weak stubs just throw UnsatisfiedLinkError.
             */

            // The function with the long JNI name. This is the one that throws
            // UnsatisfiedLinkError.
            Function fnLong = new FunctionBuilder(longName, nativeFunctionType).linkage(Linkage.weak).build();
            // The NativeCall caller pushed a GatewayFrame and will only pop it
            // if the native method exists. So we need to pop it here.
            Functions.popNativeFrame(fnLong);
            Functions.call(fnLong, Functions.BC_THROW_UNSATISIFED_LINK_ERROR, fnLong.getParameterRef(0),
                    mb.getString(String.format(UNSATISFIED_LINK_ERROR, targetInternalName,
                            methodName, methodDesc)));
            fnLong.add(new Unreachable());
            mb.addFunction(fnLong);
            FunctionRef targetFn = fnLong.ref();

            if (!isLongNativeFunctionNameRequired(method)) {
                // Generate a function with the short JNI name. This just calls
                // the function with the long name.
                Function fnShort = new FunctionBuilder(shortName, nativeFunctionType).linkage(Linkage.weak).build();
                Value resultInner = call(fnShort, fnLong.ref(), fnShort.getParameterRefs());
                fnShort.add(new Ret(resultInner));
                mb.addFunction(fnShort);
                targetFn = fnShort.ref();
            }

            return targetFn;
        } else {
            /*
             * Dynamic JNI. Generate a function which calls _bcResolveNative()
             * on the first invocation. _bcResolveNative() will resolve the JNI
             * function or throw an exception. The JNI function pointer is
             * cached for subsequent invocations.
             */
            Global g = new Global(Symbols.nativeMethodPtrSymbol(targetInternalName, methodName, methodDesc), 
                    new NullConstant(Type.I8_PTR));
            mb.addGlobal(g);
            String fnName = Symbols.nativeCallMethodSymbol(targetInternalName, methodName, methodDesc);
            Function fn = new FunctionBuilder(fnName, nativeFunctionType)
                .linkage(Linkage.external)
                .attribs(FunctionAttribute.alwaysinline, FunctionAttribute.optsize).build();
            FunctionRef ldcFn = FunctionBuilder.ldcInternal(targetInternalName).ref();
            Value theClass = call(fn, ldcFn, fn.getParameterRef(0));
            Value implI8Ptr = Functions.call(fn, Functions.BC_RESOLVE_NATIVE, fn.getParameterRef(0),
                  theClass,
                  mb.getString(methodName), 
                  mb.getString(methodDesc),
                  mb.getString(shortName),
                  mb.getString(longName),
                  g.ref());
            Variable nullTest = fn.newVariable(Type.I1);
            fn.add(new Icmp(nullTest, Icmp.Condition.ne, implI8Ptr, new NullConstant(Type.I8_PTR)));
            Label trueLabel = new Label();
            Label falseLabel = new Label();
            fn.add(new Br(nullTest.ref(), fn.newBasicBlockRef(trueLabel), fn.newBasicBlockRef(falseLabel)));
            fn.newBasicBlock(falseLabel);
            if (fn.getType().getReturnType() instanceof IntegerType) {
                fn.add(new Ret(new IntegerConstant(0, (IntegerType) fn.getType().getReturnType())));
            } else if (fn.getType().getReturnType() instanceof FloatingPointType) {
                fn.add(new Ret(new FloatingPointConstant(0.0, (FloatingPointType) fn.getType().getReturnType())));
            } else if (fn.getType().getReturnType() instanceof PointerType) {
                fn.add(new Ret(new NullConstant((PointerType) fn.getType().getReturnType())));
            } else {
                fn.add(new Ret());
            }
            fn.newBasicBlock(trueLabel);
            Variable impl = fn.newVariable(nativeFunctionType);
            fn.add(new Bitcast(impl, implI8Ptr, impl.getType()));
            Value result = call(fn, impl.ref(), fn.getParameterRefs());
            fn.add(new Ret(result));
            mb.addFunction(fn);
            return fn.ref();
        }
    }
}
