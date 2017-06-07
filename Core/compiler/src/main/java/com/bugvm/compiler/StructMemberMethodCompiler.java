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

import static com.bugvm.compiler.Types.*;
import static com.bugvm.compiler.llvm.Type.*;
import static com.bugvm.compiler.Bro.*;
import static com.bugvm.compiler.Types.*;

import com.bugvm.compiler.config.Config;
import com.bugvm.compiler.Bro.MarshalerFlags;
import com.bugvm.compiler.clazz.Clazz;
import com.bugvm.compiler.llvm.Bitcast;
import com.bugvm.compiler.llvm.Function;
import com.bugvm.compiler.llvm.Getelementptr;
import com.bugvm.compiler.llvm.Inttoptr;
import com.bugvm.compiler.llvm.Load;
import com.bugvm.compiler.llvm.PointerType;
import com.bugvm.compiler.llvm.Ret;
import com.bugvm.compiler.llvm.StructureType;
import com.bugvm.compiler.llvm.Type;
import com.bugvm.compiler.llvm.Value;
import com.bugvm.compiler.llvm.Variable;
import com.bugvm.compiler.llvm.VariableRef;

import soot.SootMethod;
import soot.VoidType;

/**
 * @author niklas
 *
 */
public class StructMemberMethodCompiler extends BroMethodCompiler {

    private StructureType structType;
    
    public StructMemberMethodCompiler(Config config) {
        super(config);
    }

    @Override
    public void reset(Clazz clazz) {
        super.reset(clazz);
        structType = null;
        if (isStruct(sootClass)) {
            structType = getStructType(sootClass);
        }
    }
    
    @Override
    protected Function doCompile(ModuleBuilder moduleBuilder, SootMethod method) {
        if ("_sizeOf".equals(method.getName()) || "sizeOf".equals(method.getName())) {
            return structSizeOf(moduleBuilder, method);
        } else {
            return structMember(moduleBuilder, method);
        }
    }
    
    private Function structSizeOf(ModuleBuilder moduleBuilder, SootMethod method) {
        Function fn = createMethodFunction(method);
        moduleBuilder.addFunction(fn);
        fn.add(new Ret(Types.sizeof(structType)));
        return fn;
    }

    private Function structMember(ModuleBuilder moduleBuilder, SootMethod method) {
        Function function = createMethodFunction(method);
        moduleBuilder.addFunction(function);
        
        // Get the value of the handle field in the Struct base class and cast it to a <structType>*
        Variable handleI64 = function.newVariable(I64);
        function.add(new Load(handleI64, Types.getFieldPtr(function, function.getParameterRef(1),
                Types.offsetof(new StructureType(Types.DATA_OBJECT, new StructureType(I64)), 1, 0), I64)));
        Variable handlePtr = function.newVariable(new PointerType(structType));
        function.add(new Inttoptr(handlePtr, handleI64.ref(), handlePtr.getType()));
        
        int offset = getStructMemberOffset(method) + 1; // Add 1 since the first type in structType is the superclass type or {}.      
        Type memberType = getStructMemberType(method);
        Variable memberPtr = function.newVariable(new PointerType(memberType));
        if (memberType != structType.getTypeAt(offset)) {
            // Several @StructMembers of different types have this offset (union)
            Variable tmp = function.newVariable(new PointerType(structType.getTypeAt(offset)));
            function.add(new Getelementptr(tmp, handlePtr.ref(), 0, offset));
            function.add(new Bitcast(memberPtr, tmp.ref(), memberPtr.getType()));
        } else {
            function.add(new Getelementptr(memberPtr, handlePtr.ref(), 0, offset));
        }
        
        VariableRef env = function.getParameterRef(0);
        if (method.getParameterCount() == 0) {
            // Getter
            Value result = loadValueForGetter(method, function, memberType, memberPtr.ref(),
                    function.getParameterRef(0), true, MarshalerFlags.CALL_TYPE_STRUCT_MEMBER);
            function.add(new Ret(result));
            
        } else {
            // Setter
            
            Value value = function.getParameterRef(2); // 'env' is parameter 0, 'this' is at 1, the value we're interested in is at index 2
            storeValueForSetter(method, function, memberType, memberPtr.ref(), env,
                    value, MarshalerFlags.CALL_TYPE_STRUCT_MEMBER);
            
            if (method.getReturnType().equals(VoidType.v())) {
                function.add(new Ret());
            } else {
                function.add(new Ret(function.getParameterRef(1)));
            }
        }
        
        return function;
    }
}
