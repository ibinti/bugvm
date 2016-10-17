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
package com.bugvm.apple.coremedia;

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
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.corevideo.*;
import com.bugvm.apple.audiotoolbox.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreMedia")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CMAttachmentBearer/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CMAttachmentBearerPtr extends Ptr<CMAttachmentBearer, CMAttachmentBearerPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CMAttachmentBearer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CMAttachmentBearer() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 4.0  and later.
     */
    public static CFType getAttachment(CFType target, String key) {
        return getAttachment(target, key, null);
    }
    /**
     * @since Available in iOS 4.0  and later.
     */
    public static CMAttachmentMode getModeOfAttachment(CFType target, String key) {
        IntPtr ptr = new IntPtr();
        getAttachment(target, key, ptr);
        return CMAttachmentMode.valueOf(ptr.get());
    }
    
    /**
     * @since Available in iOS 4.0  and later.
     */
    public static CFDictionary getAttachments(CFType target, CMAttachmentMode attachmentMode) {
        return getAttachments(null, target, attachmentMode);
    }

    /*<methods>*/
    /**
     * @since Available in iOS 4.0  and later.
     */
    @Bridge(symbol="CMSetAttachment", optional=true)
    public static native void setAttachment(CFType target, String key, CFType value, CMAttachmentMode attachmentMode);
    /**
     * @since Available in iOS 4.0  and later.
     */
    @Bridge(symbol="CMGetAttachment", optional=true)
    private static native CFType getAttachment(CFType target, String key, IntPtr attachmentModeOut);
    /**
     * @since Available in iOS 4.0  and later.
     */
    @Bridge(symbol="CMRemoveAttachment", optional=true)
    public static native void removeAttachment(CFType target, String key);
    /**
     * @since Available in iOS 4.0  and later.
     */
    @Bridge(symbol="CMRemoveAllAttachments", optional=true)
    public static native void removeAllAttachments(CFType target);
    /**
     * @since Available in iOS 4.0  and later.
     */
    @Bridge(symbol="CMCopyDictionaryOfAttachments", optional=true)
    private static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFDictionary getAttachments(CFAllocator allocator, CFType target, CMAttachmentMode attachmentMode);
    /**
     * @since Available in iOS 4.0  and later.
     */
    @Bridge(symbol="CMSetAttachments", optional=true)
    public static native void setAttachments(CFType target, CFDictionary theAttachments, CMAttachmentMode attachmentMode);
    /**
     * @since Available in iOS 4.0  and later.
     */
    @Bridge(symbol="CMPropagateAttachments", optional=true)
    public static native void propagateAttachments(CMAttachmentBearer source, CMAttachmentBearer destination);
    /*</methods>*/
}
