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
/*<annotations>*/@Library("Foundation")/*</annotations>*/
@Marshaler(/*<name>*/NSMetadataItemAttributes/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSMetadataItemAttributes/*</name>*/ 
    extends /*<extends>*/NSDictionaryWrapper/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static NSMetadataItemAttributes toObject(Class<NSMetadataItemAttributes> cls, long handle, long flags) {
            NSDictionary o = (NSDictionary) NSObject.Marshaler.toObject(NSDictionary.class, handle, flags);
            if (o == null) {
                return null;
            }
            return new NSMetadataItemAttributes(o);
        }
        @MarshalsPointer
        public static long toNative(NSMetadataItemAttributes o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.data, flags);
        }
    }
    public static class AsListMarshaler {
        @MarshalsPointer
        public static List<NSMetadataItemAttributes> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSDictionary> o = (NSArray<NSDictionary>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<NSMetadataItemAttributes> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(new NSMetadataItemAttributes(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<NSMetadataItemAttributes> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSDictionary> array = new NSMutableArray<>();
            for (NSMetadataItemAttributes i : l) {
                array.add(i.getDictionary());
            }
            return NSObject.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constructors>*/
    NSMetadataItemAttributes(NSDictionary data) {
        super(data);
    }
    /*</constructors>*/

    /*<methods>*/
    public boolean has(NSMetadataItemAttribute key) {
        return data.containsKey(key.value());
    }
    public NSObject get(NSMetadataItemAttribute key) {
        if (has(key)) {
            return data.get(key.value());
        }
        return null;
    }
    

    /**
     * @since Available in iOS 5.0 and later.
     */
    public String getFSName() {
        if (has(NSMetadataItemAttribute.FSName)) {
            NSString val = (NSString) get(NSMetadataItemAttribute.FSName);
            return val.toString();
        }
        return null;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public String getDisplayName() {
        if (has(NSMetadataItemAttribute.DisplayName)) {
            NSString val = (NSString) get(NSMetadataItemAttribute.DisplayName);
            return val.toString();
        }
        return null;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public NSURL getURL() {
        if (has(NSMetadataItemAttribute.URL)) {
            NSURL val = (NSURL) get(NSMetadataItemAttribute.URL);
            return val;
        }
        return null;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public String getPath() {
        if (has(NSMetadataItemAttribute.Path)) {
            NSString val = (NSString) get(NSMetadataItemAttribute.Path);
            return val.toString();
        }
        return null;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public long getFSSize() {
        if (has(NSMetadataItemAttribute.FSSize)) {
            NSNumber val = (NSNumber) get(NSMetadataItemAttribute.FSSize);
            return val.longValue();
        }
        return 0;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public NSDate getFSCreationDate() {
        if (has(NSMetadataItemAttribute.FSCreationDate)) {
            NSDate val = (NSDate) get(NSMetadataItemAttribute.FSCreationDate);
            return val;
        }
        return null;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public NSDate getFSContentChangeDate() {
        if (has(NSMetadataItemAttribute.FSContentChangeDate)) {
            NSDate val = (NSDate) get(NSMetadataItemAttribute.FSContentChangeDate);
            return val;
        }
        return null;
    }
    /**
     * @since Available in iOS 8.0 and later.
     */
    public String getContentType() {
        if (has(NSMetadataItemAttribute.ContentType)) {
            NSString val = (NSString) get(NSMetadataItemAttribute.ContentType);
            return val.toString();
        }
        return null;
    }
    /**
     * @since Available in iOS 8.0 and later.
     */
    public List<String> getContentTypeTree() {
        if (has(NSMetadataItemAttribute.ContentTypeTree)) {
            NSArray<NSString> val = (NSArray<NSString>) get(NSMetadataItemAttribute.ContentTypeTree);
            return val.asStringList();
        }
        return null;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public boolean isUbiquitous() {
        if (has(NSMetadataItemAttribute.IsUbiquitous)) {
            NSNumber val = (NSNumber) get(NSMetadataItemAttribute.IsUbiquitous);
            return val.booleanValue();
        }
        return false;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public boolean hasUnresolvedConflicts() {
        if (has(NSMetadataItemAttribute.HasUnresolvedConflicts)) {
            NSNumber val = (NSNumber) get(NSMetadataItemAttribute.HasUnresolvedConflicts);
            return val.booleanValue();
        }
        return false;
    }
    /**
     * @since Available in iOS 5.0 and later.
     * @deprecated Deprecated in iOS 7.0.
     */
    @Deprecated
    public boolean isDownloaded() {
        if (has(NSMetadataItemAttribute.IsDownloaded)) {
            NSNumber val = (NSNumber) get(NSMetadataItemAttribute.IsDownloaded);
            return val.booleanValue();
        }
        return false;
    }
    /**
     * @since Available in iOS 7.0 and later.
     */
    public NSMetadataItemDownloadingStatus getDownloadingStatus() {
        if (has(NSMetadataItemAttribute.DownloadingStatus)) {
            NSString val = (NSString) get(NSMetadataItemAttribute.DownloadingStatus);
            return NSMetadataItemDownloadingStatus.valueOf(val);
        }
        return null;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public boolean isDownloading() {
        if (has(NSMetadataItemAttribute.IsDownloading)) {
            NSNumber val = (NSNumber) get(NSMetadataItemAttribute.IsDownloading);
            return val.booleanValue();
        }
        return false;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public boolean isUploaded() {
        if (has(NSMetadataItemAttribute.IsUploaded)) {
            NSNumber val = (NSNumber) get(NSMetadataItemAttribute.IsUploaded);
            return val.booleanValue();
        }
        return false;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public boolean isUploading() {
        if (has(NSMetadataItemAttribute.IsUploading)) {
            NSNumber val = (NSNumber) get(NSMetadataItemAttribute.IsUploading);
            return val.booleanValue();
        }
        return false;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public double getPercentDownloaded() {
        if (has(NSMetadataItemAttribute.PercentDownloaded)) {
            NSNumber val = (NSNumber) get(NSMetadataItemAttribute.PercentDownloaded);
            return val.doubleValue();
        }
        return 0;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public double getPercentUploaded() {
        if (has(NSMetadataItemAttribute.PercentUploaded)) {
            NSNumber val = (NSNumber) get(NSMetadataItemAttribute.PercentUploaded);
            return val.doubleValue();
        }
        return 0;
    }
    /**
     * @since Available in iOS 7.0 and later.
     */
    public NSError getDownloadingError() {
        if (has(NSMetadataItemAttribute.DownloadingError)) {
            NSError val = (NSError) get(NSMetadataItemAttribute.DownloadingError);
            return val;
        }
        return null;
    }
    /**
     * @since Available in iOS 7.0 and later.
     */
    public NSError getUploadingError() {
        if (has(NSMetadataItemAttribute.UploadingError)) {
            NSError val = (NSError) get(NSMetadataItemAttribute.UploadingError);
            return val;
        }
        return null;
    }
    /**
     * @since Available in iOS 8.0 and later.
     */
    public boolean isDownloadRequested() {
        if (has(NSMetadataItemAttribute.DownloadRequested)) {
            NSNumber val = (NSNumber) get(NSMetadataItemAttribute.DownloadRequested);
            return val.booleanValue();
        }
        return false;
    }
    /**
     * @since Available in iOS 8.0 and later.
     */
    public boolean isExternalDocument() {
        if (has(NSMetadataItemAttribute.IsExternalDocument)) {
            NSNumber val = (NSNumber) get(NSMetadataItemAttribute.IsExternalDocument);
            return val.booleanValue();
        }
        return false;
    }
    /**
     * @since Available in iOS 8.0 and later.
     */
    public String getContainerDisplayName() {
        if (has(NSMetadataItemAttribute.ContainerDisplayName)) {
            NSString val = (NSString) get(NSMetadataItemAttribute.ContainerDisplayName);
            return val.toString();
        }
        return null;
    }
    /**
     * @since Available in iOS 8.0 and later.
     */
    public NSURL getURLInLocalContainer() {
        if (has(NSMetadataItemAttribute.URLInLocalContainer)) {
            NSURL val = (NSURL) get(NSMetadataItemAttribute.URLInLocalContainer);
            return val;
        }
        return null;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public double getContentRelevance() {
        if (has(NSMetadataItemAttribute.ContentRelevance)) {
            NSNumber val = (NSNumber) get(NSMetadataItemAttribute.ContentRelevance);
            return val.doubleValue();
        }
        return 0;
    }
    /*</methods>*/
    
    /*<keys>*/
    /*</keys>*/
}
