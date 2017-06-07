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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import com.bugvm.compiler.config.Config;
import com.bugvm.compiler.llvm.Alias;
import com.bugvm.compiler.llvm.BasicBlockRef;
import com.bugvm.compiler.llvm.ConstantBitcast;
import com.bugvm.compiler.llvm.DataLayout;
import com.bugvm.compiler.llvm.Function;
import com.bugvm.compiler.llvm.FunctionDeclaration;
import com.bugvm.compiler.llvm.FunctionRef;
import com.bugvm.compiler.llvm.FunctionType;
import com.bugvm.compiler.llvm.IntegerConstant;
import com.bugvm.compiler.llvm.Label;
import com.bugvm.compiler.llvm.Linkage;
import com.bugvm.compiler.llvm.PrimitiveType;
import com.bugvm.compiler.llvm.Ret;
import com.bugvm.compiler.llvm.StructureType;
import com.bugvm.compiler.llvm.Type;
import com.bugvm.compiler.llvm.Unreachable;
import com.bugvm.compiler.llvm.Value;
import com.bugvm.compiler.trampoline.Invokestatic;

import soot.SootMethod;


/**
 * 
 */
public class CallbackMethodCompiler extends BroMethodCompiler {

    public CallbackMethodCompiler(Config config) {
        super(config);
    }

    @Override
    protected Function doCompile(ModuleBuilder moduleBuilder, SootMethod method) {
        return compileCallback(moduleBuilder, method);
    }
    
    protected FunctionRef getCallbackCWrapperRef(SootMethod method, String name) {
        return new FunctionRef(name, getCallbackFunctionType(method, false));
    }
    
    protected static String createCallbackCWrapper(FunctionType functionType, String name, String innerName) {
        // We order structs by name in reverse order. The names are constructed
        // such that nested structs get names which are naturally ordered after
        // their parent struct.
        Map<String, String> structs = new TreeMap<String, String>(Collections.reverseOrder());
        
        StringBuilder hiSignature = new StringBuilder();
        hiSignature
            .append(getHiType(functionType.getReturnType()))
            .append(' ')
            .append(innerName)
            .append('(');

        StringBuilder loSignature = new StringBuilder();
        String loReturnType = getLoType(functionType.getReturnType(), name, 0, structs);
        loSignature
            .append(loReturnType)
            .append(' ')
            .append(name)
            .append('(');
        
        StringBuilder body = new StringBuilder(" {\n");
        StringBuilder args = new StringBuilder();
        
        for (int i = 0; i < functionType.getParameterTypes().length; i++) {
            String arg = "p" + i;
            if (i > 0) {
                hiSignature.append(", ");
                loSignature.append(", ");
                args.append(", ");
            }

            String hiParamType = getHiType(functionType.getParameterTypes()[i]);
            hiSignature.append(hiParamType);

            String loParamType = getLoType(functionType.getParameterTypes()[i], name, i + 1, structs);
            loSignature.append(loParamType).append(' ').append(arg);

            if (functionType.getParameterTypes()[i] instanceof StructureType) {
                args.append("(void*) &").append(arg);
            } else {
                args.append(arg);
            }
        }
        if (functionType.getParameterTypes().length == 0) {
            hiSignature.append("void");
            loSignature.append("void");
        }
        hiSignature.append(')');
        loSignature.append(')');
        
        StringBuilder header = new StringBuilder();
        for (Entry<String, String> struct : structs.entrySet()) {
            header.append("struct " + struct.getKey() + " " + struct.getValue() + ";\n");
        }
        header.append(hiSignature + ";\n");
        
        if (functionType.getReturnType() instanceof StructureType) {
            body.append("    return *((" + loReturnType + "*) " + innerName + "(" + args + "));\n");
        } else if (functionType.getReturnType() != Type.VOID) {
            body.append("    return " + innerName + "(" + args + ");\n");
        } else {
            body.append("    " + innerName + "(" + args + ");\n");
        }
        body.append("}\n");

        return header.toString() + loSignature.toString() + body.toString();
    }
    
    private Function compileCallback(ModuleBuilder moduleBuilder, SootMethod method) {
        
        Function callbackFn = null;
        FunctionType nativeFnType = null;
        boolean useCWrapper = requiresCWrapper(method);
        if (useCWrapper) {
            // The C wrapper is the function which is called by native code. It
            // handles structs passed/returned by value. It calls an LLVM function 
            // which has the same signature but all structs passed/returned by value
            // replaced by pointers (i8*).
            FunctionRef callbackCWrapperRef = getCallbackCWrapperRef(method, Symbols.callbackCSymbol(method));
            getCWrapperFunctions().add(createCallbackCWrapper(callbackCWrapperRef.getType(), 
                    callbackCWrapperRef.getName(), Symbols.callbackInnerCSymbol(method)));
            moduleBuilder.addFunctionDeclaration(new FunctionDeclaration(callbackCWrapperRef));
            Type callbackRetType = callbackCWrapperRef.getType().getReturnType() instanceof StructureType 
                    ? Type.I8_PTR : callbackCWrapperRef.getType().getReturnType();
            Type[] callbackParamTypes = new Type[callbackCWrapperRef.getType().getParameterTypes().length];
            for (int i = 0; i < callbackParamTypes.length; i++) {
                Type t = callbackCWrapperRef.getType().getParameterTypes()[i];
                if (t instanceof StructureType) {
                    t = Type.I8_PTR;
                }
                callbackParamTypes[i] = t;
            }
            moduleBuilder.addAlias(new Alias(Symbols.callbackPtrSymbol(method), 
                    Linkage._private, new ConstantBitcast(callbackCWrapperRef, Type.I8_PTR)));
            callbackFn = new FunctionBuilder(Symbols.callbackInnerCSymbol(method), 
                    new FunctionType(callbackRetType, callbackParamTypes)).build();
            nativeFnType = callbackCWrapperRef.getType();
        } else {
            FunctionType callbackFnType = getCallbackFunctionType(method, false);
            callbackFn = FunctionBuilder.callback(method, callbackFnType);
            moduleBuilder.addAlias(new Alias(Symbols.callbackPtrSymbol(method), 
                    Linkage._private, new ConstantBitcast(callbackFn.ref(), Type.I8_PTR)));
            nativeFnType = callbackFnType;
        }

        moduleBuilder.addFunction(callbackFn);

        String targetName = method.isSynchronized() 
                ? Symbols.synchronizedWrapperSymbol(method) 
                : Symbols.methodSymbol(method);
        FunctionRef targetFn = new FunctionRef(targetName, Types.getFunctionType(method));
        
        // Increase the attach count for the current thread (attaches the thread
        // if not attached)
        Value env = Functions.call(callbackFn, Functions.BC_ATTACH_THREAD_FROM_CALLBACK);

        BasicBlockRef bbSuccess = callbackFn.newBasicBlockRef(new Label("success"));
        BasicBlockRef bbFailure = callbackFn.newBasicBlockRef(new Label("failure"));
        Functions.pushCallbackFrame(callbackFn, env);
        Functions.trycatchAllEnter(callbackFn, env, bbSuccess, bbFailure);
        callbackFn.newBasicBlock(bbSuccess.getLabel());

        List<MarshaledArg> marshaledArgs = new ArrayList<MarshaledArg>();
        
        ArrayList<Value> args = new ArrayList<Value>();
        args.add(env);
        
        if (!method.isStatic()) {
            MarshalerLookup.MarshalerMethod marshalerMethod = config.getMarshalerLookup().findMarshalerMethod(new MarshalerLookup.MarshalSite(method, MarshalerLookup.MarshalSite.RECEIVER));
            MarshaledArg marshaledArg = new MarshaledArg();
            marshaledArg.paramIndex = MarshalerLookup.MarshalSite.RECEIVER;
            marshaledArgs.add(marshaledArg);
            Value arg = callbackFn.getParameterRef(0);
            String targetClassName = Types.getInternalName(method.getDeclaringClass());
            arg = marshalNativeToObject(callbackFn, marshalerMethod, marshaledArg, env, targetClassName, arg,
                    Bro.MarshalerFlags.CALL_TYPE_CALLBACK);
            args.add(arg);
        }
        
        for (int i = 0, argIdx = 0; i < method.getParameterCount(); i++, argIdx++) {
            if (!method.isStatic() && argIdx == 0) {
                argIdx++;
            }
            Value arg = callbackFn.getParameterRef(argIdx);
            soot.Type type = method.getParameterType(i);
            
            if (Bro.needsMarshaler(type)) {
                MarshalerLookup.MarshalerMethod marshalerMethod = config.getMarshalerLookup().findMarshalerMethod(new MarshalerLookup.MarshalSite(method, i));
                String targetClassName = Types.getInternalName(type);

                if (arg.getType() instanceof PrimitiveType) {
                    arg = marshalNativeToValueObject(callbackFn, marshalerMethod, env, targetClassName, arg,
                            Bro.MarshalerFlags.CALL_TYPE_CALLBACK);
                } else {
                    MarshaledArg marshaledArg = new MarshaledArg();
                    marshaledArg.paramIndex = i;
                    marshaledArgs.add(marshaledArg);
                    
                    Type nativeType = nativeFnType.getParameterTypes()[argIdx];
                    if (nativeType instanceof StructureType) {
                        // Struct passed by value on the stack. Make a heap copy of the data and marshal that.
                        DataLayout dataLayout = config.getDataLayout();
                        Value heapCopy = Functions.call(callbackFn, Functions.BC_COPY_STRUCT, env, arg,
                                new IntegerConstant(dataLayout.getAllocSize(nativeType)));
                        arg = marshalNativeToObject(callbackFn, marshalerMethod, marshaledArg, env, targetClassName, heapCopy,
                                Bro.MarshalerFlags.CALL_TYPE_CALLBACK);
                    } else {
                        arg = marshalNativeToObject(callbackFn, marshalerMethod, marshaledArg, env, targetClassName, arg,
                                Bro.MarshalerFlags.CALL_TYPE_CALLBACK);
                    }
                }
            } else {
                arg = marshalNativeToPrimitive(callbackFn, method, i, arg);
            } 
            args.add(arg);
        }
        
        Value result = call(callbackFn, targetFn, args);
        
        // Call Marshaler.updateNative() for each object that was marshaled before
        // the call.
        updateNative(method, callbackFn, env, Bro.MarshalerFlags.CALL_TYPE_CALLBACK, marshaledArgs);
        
        // Marshal the returned value to a native value before returning
        if (Bro.needsMarshaler(method.getReturnType())) {
            MarshalerLookup.MarshalerMethod marshalerMethod = config.getMarshalerLookup().findMarshalerMethod(new MarshalerLookup.MarshalSite(method));
            Type nativeType = callbackFn.getType().getReturnType();
            
            if (nativeType instanceof PrimitiveType) {
                result = marshalValueObjectToNative(callbackFn, marshalerMethod, nativeType, env, result,
                        Bro.MarshalerFlags.CALL_TYPE_CALLBACK);
            } else {
                result = marshalObjectToNative(callbackFn, marshalerMethod, null, nativeType, env, result,
                        Bro.MarshalerFlags.CALL_TYPE_CALLBACK);
            }
        } else {
            result = marshalPrimitiveToNative(callbackFn, method, result);
        }
        
        Functions.trycatchLeave(callbackFn, env);
        Functions.popCallbackFrame(callbackFn, env);
        call(callbackFn, Functions.BC_DETACH_THREAD_FROM_CALLBACK, env);
        callbackFn.add(new Ret(result));

        callbackFn.newBasicBlock(bbFailure.getLabel());
        Functions.trycatchLeave(callbackFn, env);
        Functions.popCallbackFrame(callbackFn, env);
        Value ex = call(callbackFn, Functions.BC_EXCEPTION_CLEAR, env);
        // Call Marshaler.updateNative() for each object that was marshaled before
        // the call.
        updateNative(method, callbackFn, env, Bro.MarshalerFlags.CALL_TYPE_CALLBACK, marshaledArgs);
        call(callbackFn, Functions.BC_DETACH_THREAD_FROM_CALLBACK, env);
        Functions.call(callbackFn, Functions.BC_THROW, env, ex);
        callbackFn.add(new Unreachable());
        
        return callbackFn;
    }

    private void updateNative(SootMethod method, Function fn, Value env, long flags, List<MarshaledArg> marshaledArgs) {
        for (MarshaledArg value : marshaledArgs) {
            MarshalerLookup.MarshalerMethod marshalerMethod = config.getMarshalerLookup().findMarshalerMethod(new MarshalerLookup.MarshalSite(method, value.paramIndex));
            SootMethod afterMethod = ((MarshalerLookup.PointerMarshalerMethod) marshalerMethod).getAfterCallbackCallMethod();
            if (afterMethod != null) {
                Invokestatic invokestatic = new Invokestatic(
                        Types.getInternalName(method.getDeclaringClass()),
                        Types.getInternalName(afterMethod.getDeclaringClass()),
                        afterMethod.getName(),
                        Types.getDescriptor(afterMethod));
                trampolines.add(invokestatic);
                Functions.call(fn, invokestatic.getFunctionRef(),
                        env, value.handle, value.object, 
                        new IntegerConstant(flags));
            }
        }
    }
}
