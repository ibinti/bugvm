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
package com.bugvm.apple.mediaplayer;

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
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.2 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MediaPlayer") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MPMediaEntity/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MPMediaEntityPtr extends Ptr<MPMediaEntity, MPMediaEntityPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MPMediaEntity.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MPMediaEntity() {}
    protected MPMediaEntity(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "persistentID")
    public native long getPersistentID();
    /*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 4.2 and later.
     */
    public long getPersistentIDLegacy() {
        NSNumber val = (NSNumber) getValue(MPMediaEntityProperty.EntityPersistentID);
        if (val != null) {
            return val.longValue();
        }
        return 0;
    }
    
    /**
     * @since Available in iOS 4.0 and later.
     */
    public void enumerateValues(List<MPMediaEntityProperty> properties, final VoidBlock3<MPMediaEntityProperty, NSObject, Boolean> block) {
        NSSet<NSString> set = new NSMutableSet<>();
        for (MPMediaEntityProperty property : properties) {
            set.add(property.value());
        }
        enumerateValues(set, new VoidBlock3<NSString, NSObject, BooleanPtr>() {
            @Override
            public void invoke(NSString a, NSObject b, BooleanPtr c) {
                block.invoke(MPMediaEntityProperty.valueOf(a), b, c.get());
            }
        });
    }
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "enumerateValuesForProperties:usingBlock:")
    protected native void enumerateValues(NSSet<NSString> properties, @Block VoidBlock3<NSString, NSObject, BooleanPtr> block);
    @Method(selector = "valueForProperty:")
    public native NSObject getValue(MPMediaEntityProperty property);
    @Method(selector = "canFilterByProperty:")
    public static native boolean canFilterByProperty(MPMediaEntityProperty property);
    /*</methods>*/
}
