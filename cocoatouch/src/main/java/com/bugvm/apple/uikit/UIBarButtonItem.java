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
 * @since Available in iOS 2.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIBarButtonItem/*</name>*/ 
    extends /*<extends>*/UIBarItem/*</extends>*/ 
    /*<implements>*/implements NSCoding/*</implements>*/ {

    /*<ptr>*/public static class UIBarButtonItemPtr extends Ptr<UIBarButtonItem, UIBarButtonItemPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIBarButtonItem.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    
    public interface OnClickListener {
        void onClick(UIBarButtonItem barButtonItem);
    }
    
    private static final Selector handleClick = Selector.register("handleClick");
    private static class ListenerWrapper extends NSObject {
        private final OnClickListener listener;
        private ListenerWrapper(OnClickListener listener) {
            this.listener = listener;
        }
        @Method(selector = "handleClick")
        private void handleClick(UIBarButtonItem barButtonItem) {
            listener.onClick(barButtonItem);
        }
    }
    
    public UIBarButtonItem(UIImage image, UIBarButtonItemStyle style, OnClickListener listener) { 
        super((SkipInit) null);
        if (listener != null) {
            ListenerWrapper l = new ListenerWrapper(listener);
            initObject(init(image, style, l, handleClick));
            this.addStrongRef(l);
        } else {
            initObject(init(image, style, null, null));
        }
    }
    public UIBarButtonItem(UIImage image, UIImage landscapeImagePhone, UIBarButtonItemStyle style, OnClickListener listener) {
        super((SkipInit) null);
        if (listener != null) {
            ListenerWrapper l = new ListenerWrapper(listener);
            initObject(init(image, landscapeImagePhone, style, l, handleClick));
            this.addStrongRef(l);
        } else {
            initObject(init(image, landscapeImagePhone, style, null, null));
        }
    }
    public UIBarButtonItem(String title, UIBarButtonItemStyle style, OnClickListener listener) {
        super((SkipInit) null);
        if (listener != null) {
            ListenerWrapper l = new ListenerWrapper(listener);
            initObject(init(title, style, l, handleClick));
            this.addStrongRef(l);
        } else {
            initObject(init(title, style, null, null));
        }
    }
    public UIBarButtonItem(UIBarButtonSystemItem systemItem, OnClickListener listener) {
        super((SkipInit) null);
        if (listener != null) {
            ListenerWrapper l = new ListenerWrapper(listener);
            initObject(init(systemItem, l, handleClick));
            this.addStrongRef(l);
        } else {
            initObject(init(systemItem, null, null));
        }
    }
    
    /*<constructors>*/
    public UIBarButtonItem() {}
    protected UIBarButtonItem(SkipInit skipInit) { super(skipInit); }
    public UIBarButtonItem(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    public UIBarButtonItem(UIImage image, UIBarButtonItemStyle style, NSObject target, Selector action) { super((SkipInit) null); initObject(init(image, style, target, action)); }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public UIBarButtonItem(UIImage image, UIImage landscapeImagePhone, UIBarButtonItemStyle style, NSObject target, Selector action) { super((SkipInit) null); initObject(init(image, landscapeImagePhone, style, target, action)); }
    public UIBarButtonItem(String title, UIBarButtonItemStyle style, NSObject target, Selector action) { super((SkipInit) null); initObject(init(title, style, target, action)); }
    public UIBarButtonItem(UIBarButtonSystemItem systemItem, NSObject target, Selector action) { super((SkipInit) null); initObject(init(systemItem, target, action)); }
    public UIBarButtonItem(UIView customView) { super((SkipInit) null); initObject(init(customView)); }
    /*</constructors>*/
    
    public void setOnClickListener(OnClickListener listener) {
        NSObject t = getTarget();
        if (t instanceof ListenerWrapper) {
            this.removeStrongRef(t);
        }
        ListenerWrapper l = new ListenerWrapper(listener);
        setAction(handleClick);
        setTarget(l);
        this.addStrongRef(l);
    }
    
    /*<properties>*/
    @Property(selector = "style")
    public native UIBarButtonItemStyle getStyle();
    @Property(selector = "setStyle:")
    public native void setStyle(UIBarButtonItemStyle v);
    @Property(selector = "width")
    public native @MachineSizedFloat double getWidth();
    @Property(selector = "setWidth:")
    public native void setWidth(@MachineSizedFloat double v);
    @Property(selector = "possibleTitles")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSSet.AsStringListMarshaler.class) List<String> getPossibleTitles();
    @Property(selector = "setPossibleTitles:")
    public native void setPossibleTitles(@com.bugvm.rt.bro.annotation.Marshaler(NSSet.AsStringListMarshaler.class) List<String> v);
    @Property(selector = "customView")
    public native UIView getCustomView();
    @Property(selector = "setCustomView:")
    public native void setCustomView(UIView v);
    @Property(selector = "action")
    public native Selector getAction();
    @Property(selector = "setAction:")
    public native void setAction(Selector v);
    @Property(selector = "target")
    public native NSObject getTarget();
    @Property(selector = "setTarget:", strongRef = true)
    public native void setTarget(NSObject v);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "tintColor")
    public native UIColor getTintColor();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "setTintColor:")
    public native void setTintColor(UIColor v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "buttonGroup")
    public native UIBarButtonItemGroup getButtonGroup();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    @Method(selector = "initWithImage:style:target:action:")
    protected native @Pointer long init(UIImage image, UIBarButtonItemStyle style, NSObject target, Selector action);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "initWithImage:landscapeImagePhone:style:target:action:")
    protected native @Pointer long init(UIImage image, UIImage landscapeImagePhone, UIBarButtonItemStyle style, NSObject target, Selector action);
    @Method(selector = "initWithTitle:style:target:action:")
    protected native @Pointer long init(String title, UIBarButtonItemStyle style, NSObject target, Selector action);
    @Method(selector = "initWithBarButtonSystemItem:target:action:")
    protected native @Pointer long init(UIBarButtonSystemItem systemItem, NSObject target, Selector action);
    @Method(selector = "initWithCustomView:")
    protected native @Pointer long init(UIView customView);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "setBackgroundImage:forState:barMetrics:")
    public native void setBackgroundImage(UIImage backgroundImage, UIControlState state, UIBarMetrics barMetrics);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "backgroundImageForState:barMetrics:")
    public native UIImage getBackgroundImage(UIControlState state, UIBarMetrics barMetrics);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setBackgroundImage:forState:style:barMetrics:")
    public native void setBackgroundImage(UIImage backgroundImage, UIControlState state, UIBarButtonItemStyle style, UIBarMetrics barMetrics);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "backgroundImageForState:style:barMetrics:")
    public native UIImage getBackgroundImage(UIControlState state, UIBarButtonItemStyle style, UIBarMetrics barMetrics);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "setBackgroundVerticalPositionAdjustment:forBarMetrics:")
    public native void setBackgroundVerticalPositionAdjustment(@MachineSizedFloat double adjustment, UIBarMetrics barMetrics);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "backgroundVerticalPositionAdjustmentForBarMetrics:")
    public native @MachineSizedFloat double getBackgroundVerticalPositionAdjustment(UIBarMetrics barMetrics);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "setTitlePositionAdjustment:forBarMetrics:")
    public native void setTitlePositionAdjustment(@ByVal UIOffset adjustment, UIBarMetrics barMetrics);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "titlePositionAdjustmentForBarMetrics:")
    public native @ByVal UIOffset getTitlePositionAdjustment(UIBarMetrics barMetrics);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "setBackButtonBackgroundImage:forState:barMetrics:")
    public native void setBackButtonBackgroundImage(UIImage backgroundImage, UIControlState state, UIBarMetrics barMetrics);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "backButtonBackgroundImageForState:barMetrics:")
    public native UIImage getBackButtonBackgroundImage(UIControlState state, UIBarMetrics barMetrics);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "setBackButtonTitlePositionAdjustment:forBarMetrics:")
    public native void setBackButtonTitlePositionAdjustment(@ByVal UIOffset adjustment, UIBarMetrics barMetrics);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "backButtonTitlePositionAdjustmentForBarMetrics:")
    public native @ByVal UIOffset getBackButtonTitlePositionAdjustment(UIBarMetrics barMetrics);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "setBackButtonBackgroundVerticalPositionAdjustment:forBarMetrics:")
    public native void setBackButtonBackgroundVerticalPositionAdjustment(@MachineSizedFloat double adjustment, UIBarMetrics barMetrics);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "backButtonBackgroundVerticalPositionAdjustmentForBarMetrics:")
    public native @MachineSizedFloat double getBackButtonBackgroundVerticalPositionAdjustment(UIBarMetrics barMetrics);
    @Method(selector = "encodeWithCoder:")
    public native void encode(NSCoder coder);
    /*</methods>*/
}
