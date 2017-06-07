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
package com.bugvm.apple.foundation;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.security.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSKeyedUnarchiver/*</name>*/ 
    extends /*<extends>*/NSCoder/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSKeyedUnarchiverPtr extends Ptr<NSKeyedUnarchiver, NSKeyedUnarchiverPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSKeyedUnarchiver.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSKeyedUnarchiver() {}
    protected NSKeyedUnarchiver(SkipInit skipInit) { super(skipInit); }
    public NSKeyedUnarchiver(NSData data) { super((SkipInit) null); initObject(init(data)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "delegate")
    public native NSKeyedUnarchiverDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(NSKeyedUnarchiverDelegate v);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "requiresSecureCoding")
    public native boolean requiresSecureCoding();
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Property(selector = "setRequiresSecureCoding:")
    public native void setRequiresSecureCoding(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    
    public static NSObject unarchive(File file) {
        if (file == null) {
            throw new NullPointerException("file");
        }
        return unarchiveObject(file.getAbsolutePath());
    }
    
    /*<methods>*/
    @Method(selector = "initForReadingWithData:")
    protected native @Pointer long init(NSData data);
    @Method(selector = "finishDecoding")
    public native void finishDecoding();
    @Method(selector = "setClass:forClassName:")
    public native void setClassForClassName(Class<? extends NSObject> cls, String codedName);
    @Method(selector = "classForClassName:")
    public native Class<? extends NSObject> getClassForClassName(String codedName);
    @Method(selector = "unarchiveObjectWithData:")
    public static native NSObject unarchive(NSData data);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "unarchiveTopLevelObjectWithData:error:")
    public static native NSObject unarchiveTopLevelObjectWithData$error$(NSData data, NSError.NSErrorPtr error);
    @Method(selector = "unarchiveObjectWithFile:")
    private static native NSObject unarchiveObject(String path);
    @Method(selector = "setClass:forClassName:")
    public static native void setDefaultClassForClassName(Class<? extends NSObject> cls, String codedName);
    @Method(selector = "classForClassName:")
    public static native Class<? extends NSObject> getDefaultClassForClassName(String codedName);
    /*</methods>*/
}
