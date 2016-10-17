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
/*<annotations>*/@Library("UIKit")/*</annotations>*/
/*<visibility>*/public final/*</visibility>*/ class /*<name>*/NSIndexPathExtensions/*</name>*/ 
    extends /*<extends>*/NSExtensions/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSIndexPathExtensions.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    private NSIndexPathExtensions() {}
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "section")
    public static native @MachineSizedSInt long getSection(NSIndexPath thiz);
    @Property(selector = "row")
    public static native @MachineSizedSInt long getRow(NSIndexPath thiz);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "item")
    public static native @MachineSizedSInt long getItem(NSIndexPath thiz);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "indexPathForRow:inSection:")
    protected static native NSIndexPath createIndexPathForRowInSection(ObjCClass clazz, @MachineSizedSInt long row, @MachineSizedSInt long section);
    public static NSIndexPath createIndexPathForRowInSection(@MachineSizedSInt long row, @MachineSizedSInt long section) { return createIndexPathForRowInSection(ObjCClass.getByType(NSIndexPath.class), row, section); }
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "indexPathForItem:inSection:")
    protected static native NSIndexPath createIndexPathForItemInSection(ObjCClass clazz, @MachineSizedSInt long item, @MachineSizedSInt long section);
    public static NSIndexPath createIndexPathForItemInSection(@MachineSizedSInt long item, @MachineSizedSInt long section) { return createIndexPathForItemInSection(ObjCClass.getByType(NSIndexPath.class), item, section); }
    /*</methods>*/
}
