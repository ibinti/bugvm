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
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.corelocation.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
@Marshaler(UIStateRestorationKey.Marshaler.class)
/*<annotations>*/@Library("UIKit")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIStateRestorationKey/*</name>*/ 
    extends /*<extends>*/CocoaUtility/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public static class Marshaler {
        @MarshalsPointer
        public static UIStateRestorationKey toObject(Class<UIStateRestorationKey> cls, long handle, long flags) {
            NSString o = (NSString) NSObject.Marshaler.toObject(NSString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return UIStateRestorationKey.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(UIStateRestorationKey o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.value(), flags);
        }
    }
    
    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { Bro.bind(UIStateRestorationKey.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final UIStateRestorationKey ViewControllerStoryboard = new UIStateRestorationKey("ViewControllerStoryboardKey");
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final UIStateRestorationKey ApplicationBundleVersion = new UIStateRestorationKey("ApplicationBundleVersionKey");
    /**
     * @since Available in iOS 6.0 and later.
     */
    public static final UIStateRestorationKey ApplicationUserInterfaceIdiom = new UIStateRestorationKey("ApplicationUserInterfaceIdiomKey");
    /**
     * @since Available in iOS 7.0 and later.
     */
    public static final UIStateRestorationKey ApplicationTimestamp = new UIStateRestorationKey("ApplicationTimestampKey");
    /**
     * @since Available in iOS 7.0 and later.
     */
    public static final UIStateRestorationKey ApplicationSystemVersion = new UIStateRestorationKey("ApplicationSystemVersionKey");
    
    private static UIStateRestorationKey[] values = new UIStateRestorationKey[] {ViewControllerStoryboard, ApplicationBundleVersion, ApplicationUserInterfaceIdiom, 
        ApplicationTimestamp, ApplicationSystemVersion};
    private final LazyGlobalValue<NSString> lazyGlobalValue;
    
    private UIStateRestorationKey(String getterName) {
        lazyGlobalValue = new LazyGlobalValue<>(getClass(), getterName);
    }
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    public NSString value() {
        return lazyGlobalValue.value();
    }
    
    public static UIStateRestorationKey valueOf(NSString value) {
        for (UIStateRestorationKey v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/UIStateRestorationKey/*</name>*/.class.getName());
    }
    /*<methods>*/
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="UIStateRestorationViewControllerStoryboardKey", optional=true)
    protected static native String ViewControllerStoryboardKey();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="UIApplicationStateRestorationBundleVersionKey", optional=true)
    protected static native String ApplicationBundleVersionKey();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @GlobalValue(symbol="UIApplicationStateRestorationUserInterfaceIdiomKey", optional=true)
    protected static native String ApplicationUserInterfaceIdiomKey();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @GlobalValue(symbol="UIApplicationStateRestorationTimestampKey", optional=true)
    protected static native String ApplicationTimestampKey();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @GlobalValue(symbol="UIApplicationStateRestorationSystemVersionKey", optional=true)
    protected static native String ApplicationSystemVersionKey();
    /*</methods>*/
}
