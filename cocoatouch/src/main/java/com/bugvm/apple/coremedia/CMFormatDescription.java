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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CMFormatDescription/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CMFormatDescriptionPtr extends Ptr<CMFormatDescription, CMFormatDescriptionPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CMFormatDescription.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CMFormatDescription() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @throws OSStatusException 
     * @since Available in iOS 4.0 and later.
     */
    public static CMFormatDescription create(CMMediaType mediaType, int mediaSubtype, NSDictionary<NSString, ?> extensions) throws OSStatusException {
        return create(null, mediaType, mediaSubtype, extensions);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 4.0 and later.
     */
    public static CMFormatDescription create(CFAllocator allocator, CMMediaType mediaType, int mediaSubtype, NSDictionary<NSString, ?> extensions) throws OSStatusException {
        CMFormatDescriptionPtr ptr = new CMFormatDescriptionPtr();
        OSStatus status = create0(allocator, mediaType, mediaSubtype, extensions.as(CFDictionary.class), ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @since Available in iOS 4.3 and later.
     */
    public boolean equalsTo(CMFormatDescription desc2, String formatDescriptionExtensionKeysToIgnore, String sampleDescriptionExtensionAtomKeysToIgnore) {
        return equalsTo0(desc2, new CFString(formatDescriptionExtensionKeysToIgnore), new CFString(sampleDescriptionExtensionAtomKeysToIgnore));
    }
    /**
     * @since Available in iOS 4.3 and later.
     */
    public boolean equalsTo(CMFormatDescription desc2, List<String> formatDescriptionExtensionKeysToIgnore, List<String> sampleDescriptionExtensionAtomKeysToIgnore) {
        return equalsTo0(desc2, CFArray.fromStrings(formatDescriptionExtensionKeysToIgnore), CFArray.fromStrings(sampleDescriptionExtensionAtomKeysToIgnore));
    }
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMFormatDescriptionCreate", optional=true)
    protected static native OSStatus create0(CFAllocator allocator, CMMediaType mediaType, int mediaSubtype, CFDictionary extensions, CMFormatDescription.CMFormatDescriptionPtr descOut);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMFormatDescriptionGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMFormatDescriptionEqual", optional=true)
    public native boolean equalsTo(CMFormatDescription desc2);
    /**
     * @since Available in iOS 4.3 and later.
     */
    @Bridge(symbol="CMFormatDescriptionEqualIgnoringExtensionKeys", optional=true)
    private native boolean equalsTo0(CMFormatDescription desc2, CFType formatDescriptionExtensionKeysToIgnore, CFType sampleDescriptionExtensionAtomKeysToIgnore);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMFormatDescriptionGetMediaType", optional=true)
    public native CMMediaType getMediaType();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMFormatDescriptionGetMediaSubType", optional=true)
    public native int getMediaSubType();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMFormatDescriptionGetExtensions", optional=true)
    public native CFDictionary getExtensionDictionary();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Bridge(symbol="CMFormatDescriptionGetExtension", optional=true)
    public native CFType getExtension(String extensionKey);
    /*</methods>*/
}
