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
package com.bugvm.apple.uikit;

/*<imports>*/
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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/**
 * @since Available in iOS 7.0 and later.
 */
@Marshaler(UIMotionEffectViewerOffsetValues.Marshaler.class)
/*<annotations>*/@Library("UIKit")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class UIMotionEffectViewerOffsetValues 
    extends /*<extends>*/Object/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public static class Marshaler {
        @SuppressWarnings("unchecked")
        @MarshalsPointer
        public static UIMotionEffectViewerOffsetValues toObject(Class<UIMotionEffectViewerOffsetValues> cls, long handle, long flags) {
            NSDictionary<NSString, NSObject> o = (NSDictionary<NSString, NSObject>) NSObject.Marshaler.toObject(NSDictionary.class, handle, flags);
            if (o == null) {
                return null;
            }
            return new UIMotionEffectViewerOffsetValues(o);
        }
        @MarshalsPointer
        public static long toNative(UIMotionEffectViewerOffsetValues o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.data, flags);
        }
    }
    
    /*<ptr>*/
    /*</ptr>*/
    private NSDictionary<NSString, NSObject> data;
    
    protected UIMotionEffectViewerOffsetValues(NSDictionary<NSString, NSObject> data) {
        this.data = data;
    }
    public UIMotionEffectViewerOffsetValues() {
        this.data = new NSMutableDictionary<>();
    }
    /*<bind>*/static { Bro.bind(UIMotionEffectViewerOffsetValues.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    public NSDictionary<NSString, NSObject> getDictionary() {
        return data;
    }
    
    public UIMotionEffectViewerOffsetValues put(String keypath, NSObject value) {
        data.put(new NSString(keypath), value);
        return this;
    }
    public UIMotionEffectViewerOffsetValues put(String keypath, CGPoint value) {
        data.put(new NSString(keypath), NSValue.valueOf(value));
        return this;
    }
    public UIMotionEffectViewerOffsetValues put(String keypath, CGSize value) {
        data.put(new NSString(keypath), NSValue.valueOf(value));
        return this;
    }
    public UIMotionEffectViewerOffsetValues put(String keypath, CGRect value) {
        data.put(new NSString(keypath), NSValue.valueOf(value));
        return this;
    }
    public UIMotionEffectViewerOffsetValues put(String keypath, CGAffineTransform value) {
        data.put(new NSString(keypath), NSValue.valueOf(value));
        return this;
    }
    public UIMotionEffectViewerOffsetValues put(String keypath, UIEdgeInsets value) {
        data.put(new NSString(keypath), NSValue.valueOf(value));
        return this;
    }
    public UIMotionEffectViewerOffsetValues put(String keypath, UIOffset value) {
        data.put(new NSString(keypath), NSValue.valueOf(value));
        return this;
    }
    public NSObject get(String keypath) {
        return data.get(new NSString(keypath));
    }
    public boolean contains(String keypath) {
        return data.containsKey(new NSString(keypath));
    }
    
    /*<methods>*//*</methods>*/
    @Override
    public String toString() {
        if (data != null) return data.toString();
        return super.toString();
    }
}
