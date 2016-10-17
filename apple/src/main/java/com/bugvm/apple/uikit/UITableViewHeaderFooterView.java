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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UITableViewHeaderFooterView/*</name>*/ 
    extends /*<extends>*/UIView/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UITableViewHeaderFooterViewPtr extends Ptr<UITableViewHeaderFooterView, UITableViewHeaderFooterViewPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UITableViewHeaderFooterView.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UITableViewHeaderFooterView() {}
    protected UITableViewHeaderFooterView(SkipInit skipInit) { super(skipInit); }
    public UITableViewHeaderFooterView(String reuseIdentifier) { super((SkipInit) null); initObject(init(reuseIdentifier)); }
    public UITableViewHeaderFooterView(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    
    public UITableViewHeaderFooterView(CGRect frame) {
        super(frame);
    }
    
    /*<properties>*/
    @Property(selector = "tintColor")
    public native UIColor getTintColor();
    @Property(selector = "setTintColor:")
    public native void setTintColor(UIColor v);
    @Property(selector = "textLabel")
    public native UILabel getTextLabel();
    @Property(selector = "detailTextLabel")
    public native UILabel getDetailTextLabel();
    @Property(selector = "contentView")
    public native UIView getContentView();
    @Property(selector = "backgroundView")
    public native UIView getBackgroundView();
    @Property(selector = "setBackgroundView:")
    public native void setBackgroundView(UIView v);
    @Property(selector = "reuseIdentifier")
    public native String getReuseIdentifier();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithReuseIdentifier:")
    protected native @Pointer long init(String reuseIdentifier);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    @Method(selector = "prepareForReuse")
    public native void prepareForReuse();
    /*</methods>*/
}
