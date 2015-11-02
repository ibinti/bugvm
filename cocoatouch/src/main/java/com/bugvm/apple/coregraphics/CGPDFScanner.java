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
package com.bugvm.apple.coregraphics;

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
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreGraphics")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CGPDFScanner/*</name>*/ 
    extends /*<extends>*/NativeObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CGPDFScannerPtr extends Ptr<CGPDFScanner, CGPDFScannerPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CGPDFScanner.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CGPDFScanner() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    public static CGPDFScanner create(CGPDFContentStream cs, CGPDFOperatorTable table) {
        return create(cs, table, table.localInfoId);
    }
    
    /**
     * @since Available in iOS 2.0 and later.
     */
    public CGPDFObject popObject() {
        CGPDFObject.CGPDFObjectPtr ptr = new CGPDFObject.CGPDFObjectPtr();
        if (popObject(ptr)) {
            return ptr.get();
        }
        return null;
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public boolean popBoolean() {
        BooleanPtr ptr = new BooleanPtr();
        if (popBoolean(ptr)) {
            return ptr.get();
        }
        return false;
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public long popLong() {
        MachineSizedSIntPtr ptr = new MachineSizedSIntPtr();
        if (popInteger(ptr)) {
            return ptr.get();
        }
        return 0;
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public double popDouble() {
        MachineSizedFloatPtr ptr = new MachineSizedFloatPtr();
        if (popNumber(ptr)) {
            return ptr.get();
        }
        return 0;
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public String popName() {
        BytePtr.BytePtrPtr ptr = new BytePtr.BytePtrPtr();
        if (popName(ptr)) {
            return ptr.get().toStringZ();
        }
        return null;
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public CGPDFString popString() {
        CGPDFString.CGPDFStringPtr ptr = new CGPDFString.CGPDFStringPtr();
        if (popString(ptr)) {
            return ptr.get();
        }
        return null;
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public CGPDFArray popArray() {
        CGPDFArray.CGPDFArrayPtr ptr = new CGPDFArray.CGPDFArrayPtr();
        if (popArray(ptr)) {
            return ptr.get();
        }
        return null;
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public CGPDFDictionary popDictionary() {
        CGPDFDictionary.CGPDFDictionaryPtr ptr = new CGPDFDictionary.CGPDFDictionaryPtr();
        if (popDictionary(ptr)) {
            return ptr.get();
        }
        return null;
    }
    /**
     * @since Available in iOS 2.0 and later.
     */
    public CGPDFStream popStream() {
        CGPDFStream.CGPDFStreamPtr ptr = new CGPDFStream.CGPDFStreamPtr();
        if (popStream(ptr)) {
            return ptr.get();
        }
        return null;
    }
    /*<methods>*/
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFScannerCreate", optional=true)
    private static native CGPDFScanner create(CGPDFContentStream cs, CGPDFOperatorTable table, @Pointer long info);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFScannerScan", optional=true)
    public native boolean scan();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFScannerGetContentStream", optional=true)
    public native CGPDFContentStream getContentStream();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFScannerPopObject", optional=true)
    private native boolean popObject(CGPDFObject.CGPDFObjectPtr value);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFScannerPopBoolean", optional=true)
    private native boolean popBoolean(BooleanPtr value);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFScannerPopInteger", optional=true)
    private native boolean popInteger(MachineSizedSIntPtr value);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFScannerPopNumber", optional=true)
    private native boolean popNumber(MachineSizedFloatPtr value);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFScannerPopName", optional=true)
    private native boolean popName(BytePtr.BytePtrPtr value);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFScannerPopString", optional=true)
    private native boolean popString(CGPDFString.CGPDFStringPtr value);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFScannerPopArray", optional=true)
    private native boolean popArray(CGPDFArray.CGPDFArrayPtr value);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFScannerPopDictionary", optional=true)
    private native boolean popDictionary(CGPDFDictionary.CGPDFDictionaryPtr value);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Bridge(symbol="CGPDFScannerPopStream", optional=true)
    private native boolean popStream(CGPDFStream.CGPDFStreamPtr value);
    /*</methods>*/
}
