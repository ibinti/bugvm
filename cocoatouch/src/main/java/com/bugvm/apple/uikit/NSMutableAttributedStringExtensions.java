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
/*<visibility>*/public final/*</visibility>*/ class /*<name>*/NSMutableAttributedStringExtensions/*</name>*/ 
    extends /*<extends>*/NSExtensions/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSMutableAttributedStringExtensions.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    private NSMutableAttributedStringExtensions() {}
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    public static boolean read(NSMutableAttributedString thiz, NSURL url, NSAttributedStringDocumentAttributes opts) throws NSErrorException {
        return read(thiz, url, opts, null);
    }
    public static boolean read(NSMutableAttributedString thiz, NSData data, NSAttributedStringDocumentAttributes opts) throws NSErrorException {
        return read(thiz, data, opts, null);
    }
    /*<methods>*/
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "fixAttributesInRange:")
    public static native void fixAttributesInRange(NSMutableAttributedString thiz, @ByVal NSRange range);
    /**
     * @since Available in iOS 9.0 and later.
     */
    public static boolean read(NSMutableAttributedString thiz, NSURL url, NSAttributedStringDocumentAttributes opts, NSDictionary.NSDictionaryPtr dict) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = read(thiz, url, opts, dict, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "readFromURL:options:documentAttributes:error:")
    private static native boolean read(NSMutableAttributedString thiz, NSURL url, NSAttributedStringDocumentAttributes opts, NSDictionary.NSDictionaryPtr dict, NSError.NSErrorPtr error);
    /**
     * @since Available in iOS 7.0 and later.
     */
    public static boolean read(NSMutableAttributedString thiz, NSData data, NSAttributedStringDocumentAttributes opts, NSDictionary.NSDictionaryPtr dict) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = read(thiz, data, opts, dict, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Method(selector = "readFromData:options:documentAttributes:error:")
    private static native boolean read(NSMutableAttributedString thiz, NSData data, NSAttributedStringDocumentAttributes opts, NSDictionary.NSDictionaryPtr dict, NSError.NSErrorPtr error);
    /**
     * @since Available in iOS 7.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    public static boolean readFromFileURL(NSMutableAttributedString thiz, NSURL url, NSAttributedStringDocumentAttributes opts, NSDictionary.NSDictionaryPtr dict) throws NSErrorException {
       NSError.NSErrorPtr ptr = new NSError.NSErrorPtr();
       boolean result = readFromFileURL(thiz, url, opts, dict, ptr);
       if (ptr.get() != null) { throw new NSErrorException(ptr.get()); }
       return result;
    }
    /**
     * @since Available in iOS 7.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Method(selector = "readFromFileURL:options:documentAttributes:error:")
    private static native boolean readFromFileURL(NSMutableAttributedString thiz, NSURL url, NSAttributedStringDocumentAttributes opts, NSDictionary.NSDictionaryPtr dict, NSError.NSErrorPtr error);
    /*</methods>*/
}
