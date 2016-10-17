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
package com.bugvm.apple.coreservices;

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
import com.bugvm.apple.corefoundation.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CFNetwork")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFHTTPAuthentication/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CFHTTPAuthenticationPtr extends Ptr<CFHTTPAuthentication, CFHTTPAuthenticationPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CFHTTPAuthentication.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CFHTTPAuthentication() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static CFHTTPAuthentication create(CFHTTPMessage response) {
        return create(null, response);
    }
    /*<methods>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHTTPAuthenticationGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHTTPAuthenticationCreateFromResponse", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFHTTPAuthentication create(CFAllocator alloc, CFHTTPMessage response);
    /**
     * @since Available in iOS 2.0 and later.
     */
    public boolean isValid() throws CFStreamErrorException {
       CFStreamError.CFStreamErrorPtr ptr = new CFStreamError.CFStreamErrorPtr();
       boolean result = isValid(ptr);
       if (ptr.get() != null) { throw new CFStreamErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHTTPAuthenticationIsValid", optional=true)
    private native boolean isValid(CFStreamError.CFStreamErrorPtr error);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHTTPAuthenticationAppliesToRequest", optional=true)
    public native boolean appliesToRequest(CFHTTPMessage request);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHTTPAuthenticationRequiresOrderedRequests", optional=true)
    public native boolean requiresOrderedRequests();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHTTPAuthenticationCopyRealm", optional=true)
    public native @com.bugvm.rt.bro.annotation.Marshaler(CFString.AsStringNoRetainMarshaler.class) String getRealm();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHTTPAuthenticationCopyDomains", optional=true)
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSObject.NoRetainMarshaler.class) NSArray<NSURL> getDomains();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHTTPAuthenticationCopyMethod", optional=true)
    public native @com.bugvm.rt.bro.annotation.Marshaler(CFString.AsStringNoRetainMarshaler.class) String getMethod();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHTTPAuthenticationRequiresUserNameAndPassword", optional=true)
    public native boolean requiresUserNameAndPassword();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CFHTTPAuthenticationRequiresAccountDomain", optional=true)
    public native boolean requiresAccountDomain();
    /*</methods>*/
}
