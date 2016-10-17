/*
 * Copyright (C) 2013-2015 RoboVM AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bugvm.apple.addressbook;

import java.io.*;
import java.nio.*;
import java.util.*;

import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.objc.block.*;
import com.bugvm.rt.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.corefoundation.*;

@Library("AddressBook")
public class ABPersonRelatedName {
    static { Bro.bind(ABPersonRelatedName.class); }
    
    private CFString name;
    private CFString label;
    
    public ABPersonRelatedName(String name, String label) {
        this.name = new CFString(name);
        this.label = new CFString(label);
    }
    public ABPersonRelatedName(String name, ABPersonRelatedNameLabel label) {
        this.name = new CFString(name);
        this.label = label.value();
    }
    protected ABPersonRelatedName(CFString name, CFString label) {
        this.name = name;
        this.label = label;
    }
    
    public String getName() {
        return name.toString();
    }
    protected CFString getName0() {
        return name;
    }
    
    public String getLabel() {
        return label.toString();
    }
    protected CFString getLabel0() {
        return label;
    }
}
