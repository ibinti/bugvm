/*
 * Copyright (C) 2015 RoboVM AB
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

import com.bugvm.compiler.llvm.FunctionType;
import com.bugvm.compiler.llvm.PointerType;
import com.bugvm.compiler.llvm.Type;
import org.junit.Test;
import com.bugvm.compiler.llvm.ArrayType;
import com.bugvm.compiler.llvm.StructureType;

/**
 * Tests {@link BridgeMethodCompiler}.
 */
public class BridgeMethodCompilerTest {

    @Test
    public void testCreateBridgeCWrapperNoReturnNoParameters() {
        FunctionType functionType = new FunctionType(Type.VOID);
        assertEquals(
                "void f(void* target) {\n" +
                "    ((void (*)(void)) target)();\n" +
                "}\n", 
                BridgeMethodCompiler.createBridgeCWrapper(functionType.getReturnType(),
                        functionType.getParameterTypes(), functionType.getParameterTypes(), "f"));
    }
    @Test
    public void testCreateBridgeCWrapperPrimitiveReturn() {
        FunctionType functionType = new FunctionType(Type.I32);
        assertEquals(
                "int f(void* target) {\n" +
                "    return ((int (*)(void)) target)();\n" +
                "}\n", 
                BridgeMethodCompiler.createBridgeCWrapper(functionType.getReturnType(),
                        functionType.getParameterTypes(), functionType.getParameterTypes(), "f"));
    }
    @Test
    public void testCreateBridgeCWrapperPrimitiveParameters() {
        FunctionType functionType = new FunctionType(Type.VOID, Type.I8, Type.I16, Type.I32, Type.I64, Type.FLOAT, Type.DOUBLE);
        assertEquals(
                "void f(void* target, char p0, short p1, int p2, long long p3, float p4, double p5) {\n" +
                "    ((void (*)(char, short, int, long long, float, double)) target)(p0, p1, p2, p3, p4, p5);\n" +
                "}\n", 
                BridgeMethodCompiler.createBridgeCWrapper(functionType.getReturnType(),
                        functionType.getParameterTypes(), functionType.getParameterTypes(), "f"));
    }
    @Test
    public void testCreateBridgeCWrapperPointerParameters() {
        FunctionType functionType = new FunctionType(Type.VOID, Type.I8_PTR, new PointerType(new StructureType(Type.I32)));
        assertEquals(
                "void f(void* target, void* p0, void* p1) {\n" +
                "    ((void (*)(void*, void*)) target)(p0, p1);\n" +
                "}\n", 
                BridgeMethodCompiler.createBridgeCWrapper(functionType.getReturnType(),
                        functionType.getParameterTypes(), functionType.getParameterTypes(), "f"));
    }
    @Test
    public void testCreateBridgeCWrapperPointerReturn() {
        FunctionType functionType = new FunctionType(Type.I8_PTR);
        assertEquals(
                "void* f(void* target) {\n" +
                "    return ((void* (*)(void)) target)();\n" +
                "}\n", 
                BridgeMethodCompiler.createBridgeCWrapper(functionType.getReturnType(),
                        functionType.getParameterTypes(), functionType.getParameterTypes(), "f"));
    }
    @Test
    public void testCreateBridgeCWrapperIgnoresEmptyStructAsFirstMember() {
        FunctionType functionType = new FunctionType(Type.VOID,
                new StructureType(new StructureType(), Type.I32));
        assertEquals(
                "void f(void* target, void* p0) {\n" +
                "    struct f_0001 {int m1;};\n" +
                "    ((void (*)(struct f_0001)) target)(*((struct f_0001*)p0));\n" +
                "}\n", 
                BridgeMethodCompiler.createBridgeCWrapper(functionType.getReturnType(),
                        functionType.getParameterTypes(), functionType.getParameterTypes(), "f"));
    }
    @Test
    public void testCreateBridgeCWrapperSmallStructByValParameter() {
        FunctionType functionType = new FunctionType(Type.VOID,
                new StructureType(Type.I32));
        assertEquals(
                "void f(void* target, void* p0) {\n" +
                "    struct f_0001 {int m0;};\n" +
                "    ((void (*)(struct f_0001)) target)(*((struct f_0001*)p0));\n" +
                "}\n", 
                BridgeMethodCompiler.createBridgeCWrapper(functionType.getReturnType(),
                        functionType.getParameterTypes(), functionType.getParameterTypes(), "f"));
    }
    @Test
    public void testCreateBridgeCWrapperNestedStructByValParameter() {
        FunctionType functionType = new FunctionType(Type.VOID,
                new StructureType(
                        new StructureType(Type.I32),
                        new StructureType(Type.I32)));
        assertEquals(
                "void f(void* target, void* p0) {\n" +
                "    struct f_0001_0001 {int m0;};\n" +
                "    struct f_0001_0000 {int m0;};\n" +
                "    struct f_0001 {struct f_0001_0000 m0;struct f_0001_0001 m1;};\n" +
                "    ((void (*)(struct f_0001)) target)(*((struct f_0001*)p0));\n" +
                "}\n",
                BridgeMethodCompiler.createBridgeCWrapper(functionType.getReturnType(),
                        functionType.getParameterTypes(), functionType.getParameterTypes(), "f"));
    }
    @Test
    public void testCreateBridgeCWrapperComplexNestedStructByValParameter() {
        FunctionType functionType = new FunctionType(Type.VOID,
                new StructureType(
                        new StructureType(Type.I8, Type.I16),
                        new StructureType(Type.I32, Type.I64),
                        new StructureType(Type.FLOAT, Type.DOUBLE),
                        new StructureType(Type.I8_PTR,
                                new PointerType(new StructureType(Type.I32)))));
        assertEquals(
                "void f(void* target, void* p0) {\n" +
                "    struct f_0001_0003 {void* m0;void* m1;};\n" +
                "    struct f_0001_0002 {float m0;double m1;};\n" +
                "    struct f_0001_0001 {int m0;long long m1;};\n" +
                "    struct f_0001_0000 {char m0;short m1;};\n" +
                "    struct f_0001 {struct f_0001_0000 m0;struct f_0001_0001 m1;struct f_0001_0002 m2;struct f_0001_0003 m3;};\n" +
                "    ((void (*)(struct f_0001)) target)(*((struct f_0001*)p0));\n" +
                "}\n", 
                BridgeMethodCompiler.createBridgeCWrapper(functionType.getReturnType(),
                        functionType.getParameterTypes(), functionType.getParameterTypes(), "f"));
    }
    @Test
    public void testCreateBridgeCWrapperSmallStructByValReturn() {
        FunctionType functionType = new FunctionType(new StructureType(Type.I32));
        assertEquals(
                "void f(void* target, void* ret) {\n" +
                "    struct f_0000 {int m0;};\n" +
                "    *((struct f_0000*)ret) = ((struct f_0000 (*)(void)) target)();\n" +
                "}\n", 
                BridgeMethodCompiler.createBridgeCWrapper(functionType.getReturnType(),
                        functionType.getParameterTypes(), functionType.getParameterTypes(), "f"));
    }
    @Test
    public void testCreateBridgeCWrapperNestedStructByValReturn() {
        FunctionType functionType = new FunctionType(new StructureType(new StructureType(Type.I32), new StructureType(Type.I32)));
        assertEquals(
                "void f(void* target, void* ret) {\n" +
                "    struct f_0000_0001 {int m0;};\n" +
                "    struct f_0000_0000 {int m0;};\n" +
                "    struct f_0000 {struct f_0000_0000 m0;struct f_0000_0001 m1;};\n" +
                "    *((struct f_0000*)ret) = ((struct f_0000 (*)(void)) target)();\n" +
                "}\n", 
                BridgeMethodCompiler.createBridgeCWrapper(functionType.getReturnType(),
                        functionType.getParameterTypes(), functionType.getParameterTypes(), "f"));
    }
    @Test
    public void testCreateBridgeCWrapperComplexNestedStructByValReturnAndParameter() {
        StructureType structType = new StructureType(
                new StructureType(Type.I8, Type.I16),
                new StructureType(Type.I32, Type.I64),
                new StructureType(Type.FLOAT, Type.DOUBLE),
                new ArrayType(100, Type.I32),
                new ArrayType(10, new StructureType(Type.FLOAT, Type.FLOAT)),
                new ArrayType(5, new ArrayType(10, Type.I32)),
                new StructureType(Type.I8_PTR,
                        new PointerType(new StructureType(Type.I32))));
        FunctionType functionType = new FunctionType(structType, structType);
        assertEquals(
                "void f(void* target, void* ret, void* p0) {\n" +
                "    struct f_0001_0006 {void* m0;void* m1;};\n" +
                "    struct f_0001_0004 {float m0;float m1;};\n" +
                "    struct f_0001_0002 {float m0;double m1;};\n" +
                "    struct f_0001_0001 {int m0;long long m1;};\n" +
                "    struct f_0001_0000 {char m0;short m1;};\n" +
                "    struct f_0001 {struct f_0001_0000 m0;struct f_0001_0001 m1;struct f_0001_0002 m2;int m3[100];struct f_0001_0004 m4[10];int m5[5][10];struct f_0001_0006 m6;};\n" +
                "    struct f_0000_0006 {void* m0;void* m1;};\n" +
                "    struct f_0000_0004 {float m0;float m1;};\n" +
                "    struct f_0000_0002 {float m0;double m1;};\n" +
                "    struct f_0000_0001 {int m0;long long m1;};\n" +
                "    struct f_0000_0000 {char m0;short m1;};\n" +
                "    struct f_0000 {struct f_0000_0000 m0;struct f_0000_0001 m1;struct f_0000_0002 m2;int m3[100];struct f_0000_0004 m4[10];int m5[5][10];struct f_0000_0006 m6;};\n" +
                "    *((struct f_0000*)ret) = ((struct f_0000 (*)(struct f_0001)) target)(*((struct f_0001*)p0));\n" +
                "}\n", 
                BridgeMethodCompiler.createBridgeCWrapper(functionType.getReturnType(),
                        functionType.getParameterTypes(), functionType.getParameterTypes(), "f"));
    }
    @Test
    public void testCreateBridgeCWrapperVaArgs() {
        FunctionType hiType = new FunctionType(Type.VOID, Type.I8_PTR, Type.I32, Type.I32);
        FunctionType loType = new FunctionType(Type.VOID, true, Type.I8_PTR);
        assertEquals(
                "void f(void* target, void* p0, int p1, int p2) {\n" +
                "    ((void (*)(void*, ...)) target)(p0, p1, p2);\n" +
                "}\n", 
                BridgeMethodCompiler.createBridgeCWrapper(hiType.getReturnType(),
                        hiType.getParameterTypes(), loType.getParameterTypes(), "f"));
    }
}
