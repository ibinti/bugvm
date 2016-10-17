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
package com.bugvm.apple.corevideo;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.opengles.*;
import com.bugvm.apple.metal.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreVideo")/*</annotations>*/
/*<visibility>*/public abstract/*</visibility>*/ class /*<name>*/CVBuffer/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { Bro.bind(CVBuffer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    protected CFType getAttachment(CFString key) {
        return getAttachment(key, new IntPtr());
    }
    
    protected CVAttachmentMode getAttachmentMode(CFString key) {
        IntPtr ptr = new IntPtr();
        getAttachment(key, ptr);
        return CVAttachmentMode.valueOf(ptr.get());
    }
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CVBufferSetAttachment", optional=true)
    protected native void setAttachment(CFString key, CFType value, CVAttachmentMode attachmentMode);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CVBufferGetAttachment", optional=true)
    protected native CFType getAttachment(CFString key, IntPtr attachmentMode);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CVBufferRemoveAttachment", optional=true)
    protected native void removeAttachment(CFString key);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CVBufferRemoveAllAttachments", optional=true)
    protected native void removeAllAttachments();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CVBufferGetAttachments", optional=true)
    protected native NSDictionary getAttachments(CVAttachmentMode attachmentMode);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CVBufferSetAttachments", optional=true)
    protected native void setAttachments(NSDictionary theAttachments, CVAttachmentMode attachmentMode);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CVBufferPropagateAttachments", optional=true)
    protected native void propagateAttachments(CVBuffer destinationBuffer);
    /*</methods>*/
}
