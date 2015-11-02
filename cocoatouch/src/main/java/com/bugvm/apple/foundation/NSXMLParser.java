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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSXMLParser/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSXMLParserPtr extends Ptr<NSXMLParser, NSXMLParserPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSXMLParser.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSXMLParser() {}
    protected NSXMLParser(SkipInit skipInit) { super(skipInit); }
    public NSXMLParser(NSURL url) { super((SkipInit) null); initObject(init(url)); }
    public NSXMLParser(NSData data) { super((SkipInit) null); initObject(init(data)); }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public NSXMLParser(NSInputStream stream) { super((SkipInit) null); initObject(init(stream)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "delegate")
    public native NSXMLParserDelegate getDelegate();
    @Property(selector = "setDelegate:", strongRef = true)
    public native void setDelegate(NSXMLParserDelegate v);
    @Property(selector = "shouldProcessNamespaces")
    public native boolean shouldProcessNamespaces();
    @Property(selector = "setShouldProcessNamespaces:")
    public native void setShouldProcessNamespaces(boolean v);
    @Property(selector = "shouldReportNamespacePrefixes")
    public native boolean shouldReportNamespacePrefixes();
    @Property(selector = "setShouldReportNamespacePrefixes:")
    public native void setShouldReportNamespacePrefixes(boolean v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "externalEntityResolvingPolicy")
    public native NSXMLParserExternalEntityResolvingPolicy getExternalEntityResolvingPolicy();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setExternalEntityResolvingPolicy:")
    public native void setExternalEntityResolvingPolicy(NSXMLParserExternalEntityResolvingPolicy v);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "allowedExternalEntityURLs")
    public native NSSet<NSURL> getAllowedExternalEntityURLs();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setAllowedExternalEntityURLs:")
    public native void setAllowedExternalEntityURLs(NSSet<NSURL> v);
    @Property(selector = "parserError")
    public native NSError getParserError();
    @Property(selector = "shouldResolveExternalEntities")
    public native boolean shouldResolveExternalEntities();
    @Property(selector = "setShouldResolveExternalEntities:")
    public native void setShouldResolveExternalEntities(boolean v);
    @Property(selector = "publicID")
    public native String getPublicID();
    @Property(selector = "systemID")
    public native String getSystemID();
    @Property(selector = "lineNumber")
    public native @MachineSizedSInt long getLineNumber();
    @Property(selector = "columnNumber")
    public native @MachineSizedSInt long getColumnNumber();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithContentsOfURL:")
    protected native @Pointer long init(NSURL url);
    @Method(selector = "initWithData:")
    protected native @Pointer long init(NSData data);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "initWithStream:")
    protected native @Pointer long init(NSInputStream stream);
    @Method(selector = "parse")
    public native boolean parse();
    @Method(selector = "abortParsing")
    public native void abortParsing();
    /*</methods>*/
}
