/*
 * Copyright (C) 2016 BugVM
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
package com.bugvm.apple.mediaplayer;

import java.io.*;
import java.nio.*;
import java.util.*;
import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.objc.block.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coregraphics.*;

@Marshaler(ValuedEnum.AsMachineSizedSIntMarshaler.class)
public enum MPMediaLibraryAuthorizationStatus implements ValuedEnum {

    NotDetermined(0L),
    Denied(1L),
    Restricted(2L),
    Authorized(3L);

    private final long n;

    private MPMediaLibraryAuthorizationStatus(long n) { this.n = n; }
    public long value() { return n; }
    public static MPMediaLibraryAuthorizationStatus valueOf(long n) {
        for (MPMediaLibraryAuthorizationStatus v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + MPMediaLibraryAuthorizationStatus.class.getName());
    }
}