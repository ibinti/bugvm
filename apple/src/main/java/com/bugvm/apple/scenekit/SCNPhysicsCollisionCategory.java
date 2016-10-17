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
package com.bugvm.apple.scenekit;

/*<imports>*/
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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.glkit.*;
import com.bugvm.apple.spritekit.*;
import com.bugvm.apple.opengles.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Marshaler(Bits.AsMachineSizedIntMarshaler.class)/*</annotations>*/
public final class /*<name>*/SCNPhysicsCollisionCategory/*</name>*/ extends Bits</*<name>*/SCNPhysicsCollisionCategory/*</name>*/> {
    /*<values>*/
    public static final SCNPhysicsCollisionCategory None = new SCNPhysicsCollisionCategory(0L);
    public static final SCNPhysicsCollisionCategory Default = new SCNPhysicsCollisionCategory(1L);
    public static final SCNPhysicsCollisionCategory Static = new SCNPhysicsCollisionCategory(2L);
    public static final SCNPhysicsCollisionCategory All = new SCNPhysicsCollisionCategory(Bro.IS_32BIT ? 0xffffffffL : 0xffffffffffffffffL);
    /*</values>*/

    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<methods>*//*</methods>*/

    private static final /*<name>*/SCNPhysicsCollisionCategory/*</name>*/[] values = _values(/*<name>*/SCNPhysicsCollisionCategory/*</name>*/.class);

    public /*<name>*/SCNPhysicsCollisionCategory/*</name>*/(long value) { super(value); }
    private /*<name>*/SCNPhysicsCollisionCategory/*</name>*/(long value, long mask) { super(value, mask); }
    protected /*<name>*/SCNPhysicsCollisionCategory/*</name>*/ wrap(long value, long mask) {
        return new /*<name>*/SCNPhysicsCollisionCategory/*</name>*/(value, mask);
    }
    protected /*<name>*/SCNPhysicsCollisionCategory/*</name>*/[] _values() {
        return values;
    }
    public static /*<name>*/SCNPhysicsCollisionCategory/*</name>*/[] values() {
        return values.clone();
    }
}
