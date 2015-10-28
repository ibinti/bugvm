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

import static org.junit.Assert.*;

import com.bugvm.compiler.config.Arch;
import com.bugvm.compiler.config.OS;
import com.bugvm.compiler.llvm.FunctionType;
import com.bugvm.compiler.llvm.Type;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import com.bugvm.compiler.llvm.StructureType;
import com.bugvm.llvm.Context;
import com.bugvm.llvm.Module;
import com.bugvm.llvm.Target;
import com.bugvm.llvm.TargetMachine;

import soot.Scene;
import soot.SootClass;
import soot.options.Options;

/**
 * Tests {@link Types}.
 */
public class TypesTest {

    @Before
    public void initializeSoot() {
        soot.G.reset();
        Options.v().set_output_format(Options.output_format_jimple);
        Options.v().set_include_all(true);
        Options.v().set_print_tags_in_output(true);
        Options.v().set_allow_phantom_refs(true);
        Options.v().set_soot_classpath(System.getProperty("sun.boot.class.path") + 
                ":" + System.getProperty("java.class.path"));
        Scene.v().loadNecessaryClasses();
    }
    
    private SootClass getSootClass(String name) {
        return Scene.v().loadClassAndSupport(name);
    }
    
    @Test
    public void testGetFunctionTypeFromDescriptor() {
        FunctionType type = null;
        
        type = Types.getFunctionType("()V", true);
        Assert.assertEquals(Type.VOID, type.getReturnType());
        assertEquals(1, type.getParameterTypes().length);
        Assert.assertEquals(Types.ENV_PTR, type.getParameterTypes()[0]);
        
        type = Types.getFunctionType("()V", false);
        Assert.assertEquals(Type.VOID, type.getReturnType());
        assertEquals(2, type.getParameterTypes().length);
        Assert.assertEquals(Types.ENV_PTR, type.getParameterTypes()[0]);
        Assert.assertEquals(Types.OBJECT_PTR, type.getParameterTypes()[1]);
        
        type = Types.getFunctionType("(Ljava/lang/Object;)Ljava/lang/String;", true);
        Assert.assertEquals(Types.OBJECT_PTR, type.getReturnType());
        assertEquals(2, type.getParameterTypes().length);
        Assert.assertEquals(Types.ENV_PTR, type.getParameterTypes()[0]);
        Assert.assertEquals(Types.OBJECT_PTR, type.getParameterTypes()[1]);
        
        type = Types.getFunctionType("(Ljava/lang/Object;)Ljava/lang/String;", false);
        Assert.assertEquals(Types.OBJECT_PTR, type.getReturnType());
        assertEquals(3, type.getParameterTypes().length);
        Assert.assertEquals(Types.ENV_PTR, type.getParameterTypes()[0]);
        Assert.assertEquals(Types.OBJECT_PTR, type.getParameterTypes()[1]);
        Assert.assertEquals(Types.OBJECT_PTR, type.getParameterTypes()[2]);
    }

    public static class A {
        byte A_c, A_b; Object A_a;
    }

    public static class B extends A {
        byte B_c; Object B_a;
    }

    public static class C extends B {
        byte C_a;
    }

    public static class D extends C {
        final long D_d = 0; Object D_a, D_b, D_c;
    }

    @Test
    public void testGetInstanceType() throws Exception {
        StructureType type = Types.getInstanceType(OS.ios, Arch.thumbv7, getSootClass(D.class.getName()));
        int size = getAllocSize(type, "thumbv7-unknown-ios");
        assertEquals(48, size);
    }
    
    private int getAllocSize(StructureType type, String triple) {
        Context context = null;
        Module module = null;
        TargetMachine targetMachine = null;
        try {
            context = new Context();
            module = Module.parseIR(context, "%Object = type {i8*, i8*}\n%DataObject = type {%Object}\n%t = type " + type, null);
            Target target = Target.lookupTarget(triple);
            targetMachine = target.createTargetMachine(triple);
            return (int) targetMachine.getDataLayout().getTypeAllocSize(module.getTypeByName("t"));
        } finally {
            if (module != null) {
                module.dispose();
            }
            if (context != null) {
                context.dispose();
            }
            if (targetMachine != null) {
                targetMachine.dispose();
            }
        }
    }
}
