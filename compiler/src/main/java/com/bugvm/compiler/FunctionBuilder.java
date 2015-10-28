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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.bugvm.compiler.clazz.ClazzInfo;
import com.bugvm.compiler.clazz.MethodInfo;
import com.bugvm.compiler.trampoline.Trampoline;
import com.bugvm.compiler.clazz.Clazz;
import com.bugvm.compiler.llvm.Function;
import com.bugvm.compiler.llvm.FunctionAttribute;
import com.bugvm.compiler.llvm.FunctionRef;
import com.bugvm.compiler.llvm.FunctionType;
import com.bugvm.compiler.llvm.Linkage;
import com.bugvm.compiler.llvm.Type;

import soot.SootClass;
import soot.SootField;
import soot.SootMethod;

/**
 * Builds {@link Function} objects. Always adds {@link FunctionAttribute#nounwind}
 * to the function's attributes.
 */
public class FunctionBuilder {
    private FunctionType type;
    private String name;
    private Linkage linkage = null;
    private List<FunctionAttribute> attributes = new ArrayList<FunctionAttribute>();
    private String section = null;
    private List<String> parameterNames = new ArrayList<String>();
    
    public FunctionBuilder(Trampoline t) {
        this(t.getFunctionRef());
    }

    public FunctionBuilder(FunctionRef ref) {
        this(ref.getName(), ref.getType());
    }

    public FunctionBuilder(String name, FunctionRef ref) {
        this(name, ref.getType());
    }
    
    public FunctionBuilder(String name, FunctionType type) {
        this.name = name;
        this.type = type;
        attributes.add(FunctionAttribute.nounwind);
    }

    public FunctionBuilder name(String name) {
        this.name = name;
        return this;
    }
    
    public FunctionBuilder type(FunctionType type) {
        this.type = type;
        return this;
    }
    
    public FunctionBuilder attrib(FunctionAttribute a) {
        attributes.add(a);
        return this;
    }
    
    public FunctionBuilder attribs(FunctionAttribute ... a) {
        attributes.addAll(Arrays.asList(a));
        return this;
    }
    
    public FunctionBuilder paramName(String p) {
        parameterNames.add(p);
        return this;
    }
    
    public FunctionBuilder paramNames(String ... p) {
        parameterNames.addAll(Arrays.asList(p));
        return this;
    }
    
    public FunctionBuilder linkage(Linkage linkage) {
        this.linkage = linkage;
        return this;
    }

    public FunctionBuilder section(String section) {
        this.section = section;
        return this;
    }
    
    public Function build() {
        Type[] ptypes = type.getParameterTypes();
        for (int i = parameterNames.size(); i < ptypes.length; i++) {
            parameterNames.add("p" + i);
        }
        return new Function(linkage, 
                attributes.toArray(new FunctionAttribute[attributes.size()]), 
                section, name, type, parameterNames.toArray(new String[parameterNames.size()]));
    }
    
    public static Function allocator(SootClass sootClass) {
        return new FunctionBuilder(Symbols.allocatorSymbol(Types.getInternalName(sootClass)), new FunctionType(Types.OBJECT_PTR, Types.ENV_PTR))
                .linkage(Linkage._private).attribs(FunctionAttribute.alwaysinline, FunctionAttribute.optsize).build();
    }
    
    public static Function instanceOf(Clazz clazz) {
        return instanceOf(clazz.getInternalName());
    }
    public static Function instanceOf(SootClass sootClass) {
        return instanceOf(Types.getInternalName(sootClass));
    }
    public static Function instanceOf(String internalName) {
        return new FunctionBuilder(Symbols.instanceofSymbol(internalName), new FunctionType(Type.I32, Types.ENV_PTR, Types.OBJECT_PTR))
                .linkage(Linkage.external).attribs(FunctionAttribute.alwaysinline, FunctionAttribute.optsize).build();
    }
    
    public static Function checkcast(Clazz clazz) {
        return checkcast(clazz.getInternalName());
    }
    public static Function checkcast(SootClass sootClass) {
        return checkcast(Types.getInternalName(sootClass));
    }
    public static Function checkcast(String internalName) {
        return new FunctionBuilder(Symbols.checkcastSymbol(internalName), new FunctionType(Types.OBJECT_PTR, Types.ENV_PTR, Types.OBJECT_PTR))
                .linkage(Linkage.external).attribs(FunctionAttribute.alwaysinline, FunctionAttribute.optsize).build();
    }

    public static Function trycatchEnter(SootClass sootClass) {
        return new FunctionBuilder(Symbols.trycatchenterSymbol(Types.getInternalName(sootClass)), new FunctionType(Types.OBJECT_PTR, Types.ENV_PTR))
                .linkage(Linkage.external).attribs(FunctionAttribute.alwaysinline, FunctionAttribute.optsize).build();
    }
    
    public static Function ldcInternal(String internalName) {
        return new FunctionBuilder(Symbols.ldcInternalSymbol(internalName), new FunctionType(Types.OBJECT_PTR, Types.ENV_PTR))
                .linkage(Linkage._private).attribs(FunctionAttribute.alwaysinline, FunctionAttribute.optsize).build();
    }
    
    public static Function ldcInternal(SootClass sootClass) {
        return ldcInternal(Types.getInternalName(sootClass));
    }
    
    public static Function ldcExternal(SootClass sootClass) {
        return new FunctionBuilder(Symbols.ldcExternalSymbol(Types.getInternalName(sootClass)), new FunctionType(Types.OBJECT_PTR, Types.ENV_PTR))
                .linkage(Linkage.external).attribs(FunctionAttribute.noinline, FunctionAttribute.optsize).build();
    }
    
    public static Function getter(SootField field) {
        String name = Symbols.getterSymbol(field);
        if (field.isStatic()) {
            return new FunctionBuilder(name, new FunctionType(Types.getType(field.getType()), Types.ENV_PTR))
                .linkage(Linkage._private).attribs(FunctionAttribute.alwaysinline, FunctionAttribute.optsize).build();
        } else {
            return new FunctionBuilder(name, new FunctionType(Types.getType(field.getType()), Types.ENV_PTR, Types.OBJECT_PTR))
                .linkage(field.isPrivate() ? Linkage._private : Linkage.external).attribs(FunctionAttribute.alwaysinline, FunctionAttribute.optsize).build();
        }
    }
    
    public static Function setter(SootField field) {
        String name = Symbols.setterSymbol(field);
        if (field.isStatic()) {
            return new FunctionBuilder(name, new FunctionType(Type.VOID, Types.ENV_PTR, Types.getType(field.getType())))
                .linkage(Linkage._private).attribs(FunctionAttribute.alwaysinline, FunctionAttribute.optsize).build();
        } else {
            return new FunctionBuilder(name, new FunctionType(Type.VOID, Types.ENV_PTR, Types.OBJECT_PTR, Types.getType(field.getType())))
                .linkage(field.isPrivate() || field.isFinal() ? Linkage._private : Linkage.external).attribs(FunctionAttribute.alwaysinline, FunctionAttribute.optsize).build();
        }
    }
    
    public static Function clinitWrapper(FunctionRef targetFn) {
        return new FunctionBuilder(Symbols.clinitWrapperSymbol(targetFn.getName()), targetFn)
                .linkage(Linkage.external).attribs(FunctionAttribute.noinline, FunctionAttribute.optsize).build();
    }

    public static Function lookup(SootMethod method, boolean isWeak) {
        return new FunctionBuilder(Symbols.lookupWrapperSymbol(method),
                Types.getFunctionType(method)).linkage(isWeak ? Linkage.weak : Linkage.external).build();
    }

    public static Function lookup(ClazzInfo ci, MethodInfo mi, boolean isWeak) {
        return new FunctionBuilder(
                Symbols.lookupWrapperSymbol(ci.getInternalName(), mi.getName(), mi.getDesc()),
                Types.getFunctionType(mi.getDesc(),  mi.isStatic()))
            .linkage(isWeak ? Linkage.weak : Linkage.external).build();
    }

    public static Function synchronizedWrapper(SootMethod method) {
        return new FunctionBuilder(Symbols.synchronizedWrapperSymbol(method), Types.getFunctionType(method))
                .linkage(Linkage.external).attribs(FunctionAttribute.noinline, FunctionAttribute.optsize).build();
    }
    
    public static Function method(SootMethod method, boolean weak) {
        return new FunctionBuilder(Symbols.methodSymbol(method), Types.getFunctionType(method)).linkage(weak ? Linkage.weak : Linkage.external)
                .attribs(FunctionAttribute.noinline, FunctionAttribute.optsize).build();
    }

    public static Function info(String internalName) {
        return new FunctionBuilder(Symbols.infoSymbol(internalName), new FunctionType(Type.I8_PTR_PTR))
                .linkage(Linkage.external).attribs(FunctionAttribute.alwaysinline, FunctionAttribute.optsize).build();
    }
    
    public static Function infoStruct(SootClass sootClass) {
        return info(Types.getInternalName(sootClass));
    }
    
    public static Function callback(SootMethod method, FunctionType functionType) {
        return new FunctionBuilder(Symbols.callbackSymbol(method), functionType)
                .linkage(Linkage.internal).attribs(FunctionAttribute.noinline, FunctionAttribute.optsize).build();
    }
}
