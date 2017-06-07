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

import java.util.HashSet;
import java.util.Set;

import com.bugvm.compiler.config.Config;
import com.bugvm.compiler.config.OS;
import com.bugvm.compiler.llvm.FunctionRef;
import com.bugvm.compiler.trampoline.Trampoline;
import com.bugvm.compiler.clazz.Clazz;
import com.bugvm.compiler.config.Arch;
import com.bugvm.compiler.llvm.BasicBlockRef;
import com.bugvm.compiler.llvm.Function;
import com.bugvm.compiler.llvm.FunctionType;
import com.bugvm.compiler.llvm.Label;
import com.bugvm.compiler.llvm.Ret;
import com.bugvm.compiler.llvm.Unreachable;
import com.bugvm.compiler.llvm.Value;

import soot.SootClass;
import soot.SootMethod;

/**
 *
 * @version $Id$
 */
public abstract class AbstractMethodCompiler {
    protected Config config;
    protected Clazz clazz;
    protected SootClass sootClass;
    protected String className;
    protected SootMethod sootMethod;
    protected Set<Trampoline> trampolines;
    protected Set<String> catches;
    
    public AbstractMethodCompiler(Config config) {
        this.config = config;
    }
    
    public void reset(Clazz clazz) {
        this.clazz = clazz;
        this.sootClass = clazz.getSootClass();
        className = Types.getInternalName(this.sootClass);
    }
    
    public Set<Trampoline> getTrampolines() {
        return trampolines;
    }
    
    public Set<String> getCatches() {
        return catches;
    }
    
    public final Function compile(ModuleBuilder moduleBuilder, SootMethod method) {
        sootMethod = method;
        trampolines = new HashSet<Trampoline>();
        catches = new HashSet<String>();
        Function f = doCompile(moduleBuilder, method);
        if (method.isSynchronized()) {
            compileSynchronizedWrapper(moduleBuilder, method);
        }
        return f;
    }
        
    protected abstract Function doCompile(ModuleBuilder moduleBuilder, SootMethod method);

    protected Function createMethodFunction(SootMethod method) {
        /*
         * Hack to make OSX/iOS x86 binaries link properly. The linker will
         * crash if we make method functions weak which is what we need for the
         * tree shaking. So in OSX/iOS x86 builds we make method functions
         * strong and we behave as if tree shaking was disabled.
         */
        return FunctionBuilder.method(method,
                !(config.getOs().getFamily() == OS.Family.darwin && config.getArch() == Arch.x86));
    }

    private void compileSynchronizedWrapper(ModuleBuilder moduleBuilder, SootMethod method) {
        String targetName = Symbols.methodSymbol(method);
        Function syncFn = FunctionBuilder.synchronizedWrapper(method);
        moduleBuilder.addFunction(syncFn);
        FunctionType functionType = syncFn.getType();
        FunctionRef target = new FunctionRef(targetName, functionType);
        
        Value monitor = null;
        if (method.isStatic()) {
            FunctionRef fn = FunctionBuilder.ldcInternal(sootMethod.getDeclaringClass()).ref();
            monitor = call(syncFn, fn, syncFn.getParameterRef(0));
        } else {
            monitor = syncFn.getParameterRef(1);
        }
        
        call(syncFn, MONITORENTER, syncFn.getParameterRef(0), monitor);
        BasicBlockRef bbSuccess = syncFn.newBasicBlockRef(new Label("success"));
        BasicBlockRef bbFailure = syncFn.newBasicBlockRef(new Label("failure"));
        trycatchAllEnter(syncFn, bbSuccess, bbFailure);

        syncFn.newBasicBlock(bbSuccess.getLabel());
        Value result = call(syncFn, target, syncFn.getParameterRefs());
        trycatchLeave(syncFn);
        call(syncFn, MONITOREXIT, syncFn.getParameterRef(0), monitor);
        syncFn.add(new Ret(result));

        syncFn.newBasicBlock(bbFailure.getLabel());
        trycatchLeave(syncFn);
        call(syncFn, MONITOREXIT, syncFn.getParameterRef(0), monitor);
        call(syncFn, BC_THROW_IF_EXCEPTION_OCCURRED, syncFn.getParameterRef(0));
        syncFn.add(new Unreachable());
    }
}
