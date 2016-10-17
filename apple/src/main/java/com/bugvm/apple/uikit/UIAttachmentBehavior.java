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
 * @since Available in iOS 7.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIAttachmentBehavior/*</name>*/ 
    extends /*<extends>*/UIDynamicBehavior/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIAttachmentBehaviorPtr extends Ptr<UIAttachmentBehavior, UIAttachmentBehaviorPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIAttachmentBehavior.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIAttachmentBehavior() {}
    protected UIAttachmentBehavior(SkipInit skipInit) { super(skipInit); }
    public UIAttachmentBehavior(UIDynamicItem item, @ByVal CGPoint point) { super((SkipInit) null); initObject(init(item, point)); }
    public UIAttachmentBehavior(UIDynamicItem item, @ByVal UIOffset offset, @ByVal CGPoint point) { super((SkipInit) null); initObject(init(item, offset, point)); }
    public UIAttachmentBehavior(UIDynamicItem item1, UIDynamicItem item2) { super((SkipInit) null); initObject(init(item1, item2)); }
    public UIAttachmentBehavior(UIDynamicItem item1, @ByVal UIOffset offset1, UIDynamicItem item2, @ByVal UIOffset offset2) { super((SkipInit) null); initObject(init(item1, offset1, item2, offset2)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "items")
    public native List<UIDynamicItem> getItems();
    @Property(selector = "attachedBehaviorType")
    public native UIAttachmentBehaviorType getAttachedBehaviorType();
    @Property(selector = "anchorPoint")
    public native @ByVal CGPoint getAnchorPoint();
    @Property(selector = "setAnchorPoint:")
    public native void setAnchorPoint(@ByVal CGPoint v);
    @Property(selector = "length")
    public native @MachineSizedFloat double getLength();
    @Property(selector = "setLength:")
    public native void setLength(@MachineSizedFloat double v);
    @Property(selector = "damping")
    public native @MachineSizedFloat double getDamping();
    @Property(selector = "setDamping:")
    public native void setDamping(@MachineSizedFloat double v);
    @Property(selector = "frequency")
    public native @MachineSizedFloat double getFrequency();
    @Property(selector = "setFrequency:")
    public native void setFrequency(@MachineSizedFloat double v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "frictionTorque")
    public native @MachineSizedFloat double getFrictionTorque();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setFrictionTorque:")
    public native void setFrictionTorque(@MachineSizedFloat double v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "attachmentRange")
    public native @ByVal UIFloatRange getAttachmentRange();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setAttachmentRange:")
    public native void setAttachmentRange(@ByVal UIFloatRange v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithItem:attachedToAnchor:")
    protected native @Pointer long init(UIDynamicItem item, @ByVal CGPoint point);
    @Method(selector = "initWithItem:offsetFromCenter:attachedToAnchor:")
    protected native @Pointer long init(UIDynamicItem item, @ByVal UIOffset offset, @ByVal CGPoint point);
    @Method(selector = "initWithItem:attachedToItem:")
    protected native @Pointer long init(UIDynamicItem item1, UIDynamicItem item2);
    @Method(selector = "initWithItem:offsetFromCenter:attachedToItem:offsetFromCenter:")
    protected native @Pointer long init(UIDynamicItem item1, @ByVal UIOffset offset1, UIDynamicItem item2, @ByVal UIOffset offset2);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "slidingAttachmentWithItem:attachedToItem:attachmentAnchor:axisOfTranslation:")
    public static native UIAttachmentBehavior getSlidingAttachment(UIDynamicItem item1, UIDynamicItem item2, @ByVal CGPoint point, @ByVal CGVector axis);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "slidingAttachmentWithItem:attachmentAnchor:axisOfTranslation:")
    public static native UIAttachmentBehavior getSlidingAttachment(UIDynamicItem item, @ByVal CGPoint point, @ByVal CGVector axis);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "limitAttachmentWithItem:offsetFromCenter:attachedToItem:offsetFromCenter:")
    public static native UIAttachmentBehavior getLimitAttachment(UIDynamicItem item1, @ByVal UIOffset offset1, UIDynamicItem item2, @ByVal UIOffset offset2);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "fixedAttachmentWithItem:attachedToItem:attachmentAnchor:")
    public static native UIAttachmentBehavior getFixedAttachment(UIDynamicItem item1, UIDynamicItem item2, @ByVal CGPoint point);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "pinAttachmentWithItem:attachedToItem:attachmentAnchor:")
    public static native UIAttachmentBehavior getPinAttachment(UIDynamicItem item1, UIDynamicItem item2, @ByVal CGPoint point);
    /*</methods>*/
}
