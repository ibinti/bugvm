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
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSXMLParserDelegateAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSXMLParserDelegate/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @NotImplemented("parserDidStartDocument:")
    public void didStartDocument(NSXMLParser parser) {}
    @NotImplemented("parserDidEndDocument:")
    public void didEndDocument(NSXMLParser parser) {}
    @NotImplemented("parser:foundNotationDeclarationWithName:publicID:systemID:")
    public void foundNotationDeclaration(NSXMLParser parser, String name, String publicID, String systemID) {}
    @NotImplemented("parser:foundUnparsedEntityDeclarationWithName:publicID:systemID:notationName:")
    public void foundUnparsedEntityDeclaration(NSXMLParser parser, String name, String publicID, String systemID, String notationName) {}
    @NotImplemented("parser:foundAttributeDeclarationWithName:forElement:type:defaultValue:")
    public void foundAttributeDeclaration(NSXMLParser parser, String attributeName, String elementName, String type, String defaultValue) {}
    @NotImplemented("parser:foundElementDeclarationWithName:model:")
    public void foundElementDeclaration(NSXMLParser parser, String elementName, String model) {}
    @NotImplemented("parser:foundInternalEntityDeclarationWithName:value:")
    public void foundInternalEntityDeclaration(NSXMLParser parser, String name, String value) {}
    @NotImplemented("parser:foundExternalEntityDeclarationWithName:publicID:systemID:")
    public void foundExternalEntityDeclaration(NSXMLParser parser, String name, String publicID, String systemID) {}
    @NotImplemented("parser:didStartElement:namespaceURI:qualifiedName:attributes:")
    public void didStartElement(NSXMLParser parser, String elementName, String namespaceURI, String qName, @com.bugvm.rt.bro.annotation.Marshaler(NSDictionary.AsStringMapMarshaler.class) Map<String, NSObject> attributeDict) {}
    @NotImplemented("parser:didEndElement:namespaceURI:qualifiedName:")
    public void didEndElement(NSXMLParser parser, String elementName, String namespaceURI, String qName) {}
    @NotImplemented("parser:didStartMappingPrefix:toURI:")
    public void didStartMappingPrefix(NSXMLParser parser, String prefix, String namespaceURI) {}
    @NotImplemented("parser:didEndMappingPrefix:")
    public void didEndMappingPrefix(NSXMLParser parser, String prefix) {}
    @NotImplemented("parser:foundCharacters:")
    public void foundCharacters(NSXMLParser parser, String string) {}
    @NotImplemented("parser:foundIgnorableWhitespace:")
    public void foundIgnorableWhitespace(NSXMLParser parser, String whitespaceString) {}
    @NotImplemented("parser:foundProcessingInstructionWithTarget:data:")
    public void foundProcessingInstruction(NSXMLParser parser, String target, String data) {}
    @NotImplemented("parser:foundComment:")
    public void foundComment(NSXMLParser parser, String comment) {}
    @NotImplemented("parser:foundCDATA:")
    public void foundCDATA(NSXMLParser parser, NSData CDATABlock) {}
    @NotImplemented("parser:resolveExternalEntityName:systemID:")
    public NSData resolveExternalEntityName(NSXMLParser parser, String name, String systemID) { return null; }
    @NotImplemented("parser:parseErrorOccurred:")
    public void parseErrorOccurred(NSXMLParser parser, NSError parseError) {}
    @NotImplemented("parser:validationErrorOccurred:")
    public void validationErrorOccurred(NSXMLParser parser, NSError validationError) {}
    /*</methods>*/
}
