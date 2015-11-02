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
/**
 * @since Available in iOS 8.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSItemProvider/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSItemProviderPtr extends Ptr<NSItemProvider, NSItemProviderPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSItemProvider.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSItemProvider() {}
    protected NSItemProvider(SkipInit skipInit) { super(skipInit); }
    public NSItemProvider(NSObject item, String typeIdentifier) { super((SkipInit) null); initObject(init(item, typeIdentifier)); }
    public NSItemProvider(NSURL fileURL) { super((SkipInit) null); initObject(init(fileURL)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "registeredTypeIdentifiers")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getRegisteredTypeIdentifiers();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "previewImageHandler")
    public native @Block("(@Block,,)") VoidBlock3<VoidBlock2<NSObject, NSError>, ObjCClass, NSDictionary<?, ?>> getPreviewImageHandler();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setPreviewImageHandler:")
    public native void setPreviewImageHandler(@Block("(@Block,,)") VoidBlock3<VoidBlock2<NSObject, NSError>, ObjCClass, NSDictionary<?, ?>> v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    @GlobalValue(symbol="NSExtensionJavaScriptPreprocessingResultsKey", optional=true)
    public static native String JavaScriptPreprocessingResultsKey();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @GlobalValue(symbol="NSExtensionJavaScriptFinalizeArgumentKey", optional=true)
    public static native String JavaScriptFinalizeArgumentKey();
    
    @Method(selector = "initWithItem:typeIdentifier:")
    protected native @Pointer long init(NSObject item, String typeIdentifier);
    @Method(selector = "initWithContentsOfURL:")
    protected native @Pointer long init(NSURL fileURL);
    @Method(selector = "registerItemForTypeIdentifier:loadHandler:")
    public native void registerItemForTypeIdentifier(String typeIdentifier, @Block("(@Block,,)") VoidBlock3<VoidBlock2<NSObject, NSError>, ObjCClass, NSDictionary<?, ?>> loadHandler);
    @Method(selector = "hasItemConformingToTypeIdentifier:")
    public native boolean hasItemConformingToTypeIdentifier(String typeIdentifier);
    @Method(selector = "loadItemForTypeIdentifier:options:completionHandler:")
    public native void loadItemForTypeIdentifier(String typeIdentifier, NSItemProviderOptions options, @Block VoidBlock2<NSObject, NSError> completionHandler);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "loadPreviewImageWithOptions:completionHandler:")
    public native void loadPreviewImage(NSItemProviderOptions options, @Block VoidBlock2<NSObject, NSError> completionHandler);
    /*</methods>*/
}
