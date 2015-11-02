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
package com.bugvm.apple.corefoundation;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreservices.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreFoundation")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFError/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CFErrorPtr extends Ptr<CFError, CFErrorPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CFError.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CFError() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    public static CFError create(String domain, @MachineSizedSInt long code, NSDictionary<NSString, NSObject> userInfo) {
        return create(null, domain, code, userInfo);
    }
    /*<methods>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFErrorGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFErrorCreate", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFError create(CFAllocator allocator, String domain, @MachineSizedSInt long code, NSDictionary userInfo);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFErrorGetDomain", optional=true)
    public native String getDomain();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFErrorGetCode", optional=true)
    public native @MachineSizedSInt long getCode();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFErrorCopyUserInfo", optional=true)
    public native NSDictionary getUserInfo();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFErrorCopyFailureReason", optional=true)
    public native @com.bugvm.rt.bro.annotation.Marshaler(CFString.AsStringNoRetainMarshaler.class) String getFailureReason();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFErrorCopyRecoverySuggestion", optional=true)
    public native @com.bugvm.rt.bro.annotation.Marshaler(CFString.AsStringNoRetainMarshaler.class) String getRecoverySuggestion();
    /*</methods>*/
}
