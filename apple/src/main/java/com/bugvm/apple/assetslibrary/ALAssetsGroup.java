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
package com.bugvm.apple.assetslibrary;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.imageio.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.0 and later.
 * @deprecated Deprecated in iOS 9.0.
 */
@Deprecated
/*</javadoc>*/
/*<annotations>*/@Library("AssetsLibrary") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/ALAssetsGroup/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class ALAssetsGroupPtr extends Ptr<ALAssetsGroup, ALAssetsGroupPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(ALAssetsGroup.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public ALAssetsGroup() {}
    protected ALAssetsGroup(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 5.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Property(selector = "isEditable")
    public native boolean isEditable();
    /*</properties>*/
    /*<members>*//*</members>*/
    
    /* Convenience methods */
    public String getName() {
        NSString val = (NSString)getValue(ALAssetsGroupProperty.Name);
        if (val != null) {
            return val.toString();
        }
        return null;
    }
    public ALAssetsGroupType getType() {
        NSNumber val = (NSNumber)getValue(ALAssetsGroupProperty.Type);
        if (val != null) {
            return new ALAssetsGroupType(val.longValue());
        }
        return null;
    }
    public String getPersistentID() {
        NSString val = (NSString)getValue(ALAssetsGroupProperty.PersistentID);
        if (val != null) {
            return val.toString();
        }
        return null;
    }
    public NSURL getURL() {
        NSURL val = (NSURL)getValue(ALAssetsGroupProperty.URL);
        if (val != null) {
            return val;
        }
        return null;
    }
    /*<methods>*/
    /**
     * @since Available in iOS 4.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Method(selector = "valueForProperty:")
    public native NSObject getValue(ALAssetsGroupProperty property);
    /**
     * @since Available in iOS 4.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @WeaklyLinked
    @Method(selector = "posterImage")
    public native CGImage getPosterImage();
    /**
     * @since Available in iOS 4.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Method(selector = "setAssetsFilter:")
    public native void setAssetsFilter(ALAssetsFilter filter);
    /**
     * @since Available in iOS 4.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Method(selector = "numberOfAssets")
    public native @MachineSizedSInt long getNumberOfAssets();
    /**
     * @since Available in iOS 4.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Method(selector = "enumerateAssetsUsingBlock:")
    public native void enumerateAssets(@Block("(,@MachineSizedUInt,)") VoidBlock3<ALAsset, Long, BooleanPtr> enumerationBlock);
    /**
     * @since Available in iOS 4.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Method(selector = "enumerateAssetsWithOptions:usingBlock:")
    public native void enumerateAssets(NSEnumerationOptions options, @Block("(,@MachineSizedUInt,)") VoidBlock3<ALAsset, Long, BooleanPtr> enumerationBlock);
    /**
     * @since Available in iOS 4.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Method(selector = "enumerateAssetsAtIndexes:options:usingBlock:")
    public native void enumerateAssets(NSIndexSet indexSet, NSEnumerationOptions options, @Block("(,@MachineSizedUInt,)") VoidBlock3<ALAsset, Long, BooleanPtr> enumerationBlock);
    /**
     * @since Available in iOS 5.0 and later.
     * @deprecated Deprecated in iOS 9.0.
     */
    @Deprecated
    @Method(selector = "addAsset:")
    public native boolean addAsset(ALAsset asset);
    /*</methods>*/
}
