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
package com.bugvm.apple.security;

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
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("Security")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SecSharedCredential/*</name>*/ 
    extends /*<extends>*/CocoaUtility/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { Bro.bind(SecSharedCredential.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    public static void requestSharedWebCredential(String fqdn, String account, final VoidBlock2<List<SecCredential>, NSError> completionHandler) {
        // TODO remove this method once we can marshal block arguments.
        requestSharedWebCredential0(fqdn, account, new VoidBlock2<CFArray, NSError>() {
            @Override
            public void invoke(CFArray a, NSError b) {
                List<SecCredential> list = null;
                if (a != null) {
                    list = new ArrayList<>();
                    for (int i = 0; i < a.size(); i++) {
                        list.add(new SecCredential(a.get(i, CFDictionary.class)));
                    }
                }
                completionHandler.invoke(list, b);
            }
        });
    }

    /*<methods>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Bridge(symbol="SecAddSharedWebCredential", optional=true)
    public static native void addSharedWebCredential(String fqdn, String account, String password, @Block VoidBlock1<NSError> completionHandler);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Bridge(symbol="SecRequestSharedWebCredential", optional=true)
    protected static native void requestSharedWebCredential0(String fqdn, String account, @Block VoidBlock2<CFArray, NSError> completionHandler);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Bridge(symbol="SecCreateSharedWebCredentialPassword", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFString.AsStringNoRetainMarshaler.class) String createSharedWebCredentialPassword();
    /*</methods>*/
}
