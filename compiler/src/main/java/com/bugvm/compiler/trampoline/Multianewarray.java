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
package com.bugvm.compiler.trampoline;

import com.bugvm.compiler.Types;
import com.bugvm.compiler.llvm.FunctionType;
import com.bugvm.compiler.llvm.PointerType;
import com.bugvm.compiler.llvm.Type;


/**
 *
 * @version $Id$
 */
public class Multianewarray extends Trampoline {
    private static final long serialVersionUID = 1L;
    
    public Multianewarray(String callingClass, String targetClass) {
        super(callingClass, targetClass);
    }


    @Override
    public FunctionType getFunctionType() {
        return new FunctionType(Types.OBJECT_PTR, Types.ENV_PTR, Type.I32, new PointerType(Type.I32));
    }
}
