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
package com.bugvm.apple.mediaplayer;

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
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coregraphics.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 3.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MediaPlayer") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MPMediaPlaylist/*</name>*/ 
    extends /*<extends>*/MPMediaItemCollection/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MPMediaPlaylistPtr extends Ptr<MPMediaPlaylist, MPMediaPlaylistPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MPMediaPlaylist.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MPMediaPlaylist() {}
    protected MPMediaPlaylist(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "persistentID")
    public native long getPersistentID();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "name")
    public native String getName();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "playlistAttributes")
    public native MPMediaPlaylistAttribute getPlaylistAttributes();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "seedItems")
    public native NSArray<MPMediaItem> getSeedItems();
    /*</properties>*/
    /*<members>*//*</members>*/
    public long getPersistentIDLegacy() {
        NSNumber val = (NSNumber) getValue(MPMediaPlaylistProperty.PlaylistPersistendID);
        if (val != null) {
            return val.longValue();
        }
        return 0;
    }
    public String getNameLegacy() {
        NSString val = (NSString) getValue(MPMediaPlaylistProperty.Name);
        if (val != null) {
            return val.toString();
        }
        return null;
    }
    public MPMediaPlaylistAttribute getPlaylistAttributesLegacy() {
        NSNumber val = (NSNumber) getValue(MPMediaPlaylistProperty.PlaylistAttributes);
        if (val != null) {
            return new MPMediaPlaylistAttribute(val.intValue());
        }
        return null;
    }
    @SuppressWarnings("unchecked")
    public NSArray<MPMediaItem> getSeedItemsLegacy() {
        NSArray<MPMediaItem> val = (NSArray<MPMediaItem>) getValue(MPMediaPlaylistProperty.SeedItems);
        if (val != null) {
            return val;
        }
        return null;
    }
    /*<methods>*/
    
    /*</methods>*/
}
