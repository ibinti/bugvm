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
package com.bugvm.apple.mapkit;

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
import com.bugvm.apple.corelocation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 7.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MapKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MKTileOverlay/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements MKOverlay/*</implements>*/ {

    /*<ptr>*/public static class MKTileOverlayPtr extends Ptr<MKTileOverlay, MKTileOverlayPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MKTileOverlay.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MKTileOverlay() {}
    protected MKTileOverlay(SkipInit skipInit) { super(skipInit); }
    public MKTileOverlay(String URLTemplate) { super((SkipInit) null); initObject(init(URLTemplate)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "tileSize")
    public native @ByVal CGSize getTileSize();
    @Property(selector = "setTileSize:")
    public native void setTileSize(@ByVal CGSize v);
    @Property(selector = "isGeometryFlipped")
    public native boolean isGeometryFlipped();
    @Property(selector = "setGeometryFlipped:")
    public native void setGeometryFlipped(boolean v);
    @Property(selector = "minimumZ")
    public native @MachineSizedSInt long getMinimumZ();
    @Property(selector = "setMinimumZ:")
    public native void setMinimumZ(@MachineSizedSInt long v);
    @Property(selector = "maximumZ")
    public native @MachineSizedSInt long getMaximumZ();
    @Property(selector = "setMaximumZ:")
    public native void setMaximumZ(@MachineSizedSInt long v);
    @Property(selector = "URLTemplate")
    public native String getURLTemplate();
    @Property(selector = "canReplaceMapContent")
    public native boolean canReplaceMapContent();
    @Property(selector = "setCanReplaceMapContent:")
    public native void setCanReplaceMapContent(boolean v);
    @Property(selector = "coordinate")
    public native @ByVal CLLocationCoordinate2D getCoordinate();
    @Property(selector = "boundingMapRect")
    public native @ByVal MKMapRect getBoundingMapRect();
    @Property(selector = "setCoordinate:")
    public native void setCoordinate(@ByVal CLLocationCoordinate2D v);
    @Property(selector = "title")
    public native String getTitle();
    @Property(selector = "subtitle")
    public native String getSubtitle();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithURLTemplate:")
    protected native @Pointer long init(String URLTemplate);
    @Method(selector = "URLForTilePath:")
    public native NSURL getURL(@ByVal MKTileOverlayPath path);
    @Method(selector = "loadTileAtPath:result:")
    public native void loadTile(@ByVal MKTileOverlayPath path, @Block VoidBlock2<NSData, NSError> result);
    @Method(selector = "intersectsMapRect:")
    public native boolean intersects(@ByVal MKMapRect mapRect);
    /*</methods>*/
}
