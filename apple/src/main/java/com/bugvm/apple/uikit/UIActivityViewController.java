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
/**
 * @since Available in iOS 6.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIActivityViewController/*</name>*/ 
    extends /*<extends>*/UIViewController/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIActivityViewControllerPtr extends Ptr<UIActivityViewController, UIActivityViewControllerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIActivityViewController.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIActivityViewController() {}
    protected UIActivityViewController(SkipInit skipInit) { super(skipInit); }
    public UIActivityViewController(String nibNameOrNil, NSBundle nibBundleOrNil) { super((SkipInit) null); initObject(init(nibNameOrNil, nibBundleOrNil)); }
    public UIActivityViewController(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    public UIActivityViewController(NSArray<?> activityItems, NSArray<UIActivity> applicationActivities) { super((SkipInit) null); initObject(init(activityItems, applicationActivities)); }
    /*</constructors>*/
    public UIActivityViewController(List<?> activityItems, NSArray<UIActivity> applicationActivities) {
        super((SkipInit) null);
        NSArray<NSObject> items = new NSMutableArray<>();
        for (Object item : activityItems) {
            if (!(item instanceof NSObject)) {
                if (item instanceof String) {
                    items.add(new NSString((String) item));
                } else if (item instanceof Number) {
                    items.add(NSNumber.valueOf((Number) item));
                } else {
                    throw new IllegalArgumentException("Unsupported activity item type: " + item);
                }
            } else {
                items.add((NSObject)item);
            }
        }
        initObject(init(items, applicationActivities));
    }
    /*<properties>*/
    /**
     * @since Available in iOS 6.0 and later.
     * @deprecated Deprecated in iOS 8.0.
     */
    @Deprecated
    @Property(selector = "completionHandler")
    public native @Block VoidBlock2<String, Boolean> getCompletionHandler();
    /**
     * @since Available in iOS 6.0 and later.
     * @deprecated Deprecated in iOS 8.0.
     */
    @Deprecated
    @Property(selector = "setCompletionHandler:")
    public native void setCompletionHandler(@Block VoidBlock2<String, Boolean> v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "completionWithItemsHandler")
    public native @Block VoidBlock4<String, Boolean, NSArray<NSObject>, NSError> getCompletionWithItemsHandler();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setCompletionWithItemsHandler:")
    public native void setCompletionWithItemsHandler(@Block VoidBlock4<String, Boolean, NSArray<NSObject>, NSError> v);
    @Property(selector = "excludedActivityTypes")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getExcludedActivityTypes();
    @Property(selector = "setExcludedActivityTypes:")
    public native void setExcludedActivityTypes(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithNibName:bundle:")
    protected native @Pointer long init(String nibNameOrNil, NSBundle nibBundleOrNil);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    @Method(selector = "initWithActivityItems:applicationActivities:")
    protected native @Pointer long init(NSArray<?> activityItems, NSArray<UIActivity> applicationActivities);
    /*</methods>*/
}
