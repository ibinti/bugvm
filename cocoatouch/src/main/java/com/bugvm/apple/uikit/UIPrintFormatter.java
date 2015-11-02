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
 * @since Available in iOS 4.2 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("UIKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UIPrintFormatter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class UIPrintFormatterPtr extends Ptr<UIPrintFormatter, UIPrintFormatterPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(UIPrintFormatter.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public UIPrintFormatter() {}
    protected UIPrintFormatter(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "printPageRenderer")
    public native UIPrintPageRenderer getPrintPageRenderer();
    @Property(selector = "maximumContentHeight")
    public native @MachineSizedFloat double getMaximumContentHeight();
    @Property(selector = "setMaximumContentHeight:")
    public native void setMaximumContentHeight(@MachineSizedFloat double v);
    @Property(selector = "maximumContentWidth")
    public native @MachineSizedFloat double getMaximumContentWidth();
    @Property(selector = "setMaximumContentWidth:")
    public native void setMaximumContentWidth(@MachineSizedFloat double v);
    @Property(selector = "contentInsets")
    public native @ByVal UIEdgeInsets getContentInsets();
    @Property(selector = "setContentInsets:")
    public native void setContentInsets(@ByVal UIEdgeInsets v);
    @Property(selector = "perPageContentInsets")
    public native @ByVal UIEdgeInsets getPerPageContentInsets();
    @Property(selector = "setPerPageContentInsets:")
    public native void setPerPageContentInsets(@ByVal UIEdgeInsets v);
    @Property(selector = "startPage")
    public native @MachineSizedSInt long getStartPage();
    @Property(selector = "setStartPage:")
    public native void setStartPage(@MachineSizedSInt long v);
    @Property(selector = "pageCount")
    public native @MachineSizedSInt long getPageCount();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "removeFromPrintPageRenderer")
    public native void removeFromPrintPageRenderer();
    @Method(selector = "rectForPageAtIndex:")
    public native @ByVal CGRect getRectForPage(@MachineSizedSInt long pageIndex);
    @Method(selector = "drawInRect:forPageAtIndex:")
    public native void draw(@ByVal CGRect rect, @MachineSizedSInt long pageIndex);
    /*</methods>*/
}
