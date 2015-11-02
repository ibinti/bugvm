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
package com.bugvm.apple.avfoundation;

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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.corevideo.*;
import com.bugvm.apple.mediatoolbox.*;
import com.bugvm.apple.audiotoolbox.*;
import com.bugvm.apple.audiounit.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @StronglyLinked/*</annotations>*/
@Marshaler(/*<name>*/AVMetadataKeyCommon/*</name>*/.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVMetadataKeyCommon/*</name>*/ 
    extends /*<extends>*/AVMetadataKey/*</extends>*/
    /*<implements>*//*</implements>*/ {

    static { Bro.bind(/*<name>*/AVMetadataKeyCommon/*</name>*/.class); }

    /*<marshalers>*/
    public static class Marshaler {
        @MarshalsPointer
        public static AVMetadataKeyCommon toObject(Class<AVMetadataKeyCommon> cls, long handle, long flags) {
            NSString o = (NSString) NSObject.Marshaler.toObject(NSString.class, handle, flags);
            if (o == null) {
                return null;
            }
            return AVMetadataKeyCommon.valueOf(o);
        }
        @MarshalsPointer
        public static long toNative(AVMetadataKeyCommon o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.value(), flags);
        }
    }
    public static class AsListMarshaler {
        @SuppressWarnings("unchecked")
        @MarshalsPointer
        public static List<AVMetadataKeyCommon> toObject(Class<? extends NSObject> cls, long handle, long flags) {
            NSArray<NSString> o = (NSArray<NSString>) NSObject.Marshaler.toObject(NSArray.class, handle, flags);
            if (o == null) {
                return null;
            }
            List<AVMetadataKeyCommon> list = new ArrayList<>();
            for (int i = 0; i < o.size(); i++) {
                list.add(AVMetadataKeyCommon.valueOf(o.get(i)));
            }
            return list;
        }
        @MarshalsPointer
        public static long toNative(List<AVMetadataKeyCommon> l, long flags) {
            if (l == null) {
                return 0L;
            }
            NSArray<NSString> array = new NSMutableArray<>();
            for (AVMetadataKeyCommon o : l) {
                array.add(o.value());
            }
            return NSObject.Marshaler.toNative(array, flags);
        }
    }
    /*</marshalers>*/

    /*<constants>*/
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Title = new AVMetadataKeyCommon("Title");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Creator = new AVMetadataKeyCommon("Creator");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Subject = new AVMetadataKeyCommon("Subject");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Description = new AVMetadataKeyCommon("Description");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Publisher = new AVMetadataKeyCommon("Publisher");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Contributor = new AVMetadataKeyCommon("Contributor");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon CreationDate = new AVMetadataKeyCommon("CreationDate");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon LastModifiedDate = new AVMetadataKeyCommon("LastModifiedDate");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Type = new AVMetadataKeyCommon("Type");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Format = new AVMetadataKeyCommon("Format");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Identifier = new AVMetadataKeyCommon("Identifier");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Source = new AVMetadataKeyCommon("Source");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Language = new AVMetadataKeyCommon("Language");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Relation = new AVMetadataKeyCommon("Relation");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Location = new AVMetadataKeyCommon("Location");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Copyrights = new AVMetadataKeyCommon("Copyrights");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon AlbumName = new AVMetadataKeyCommon("AlbumName");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Author = new AVMetadataKeyCommon("Author");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Artist = new AVMetadataKeyCommon("Artist");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Artwork = new AVMetadataKeyCommon("Artwork");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Make = new AVMetadataKeyCommon("Make");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Model = new AVMetadataKeyCommon("Model");
    /**
     * @since Available in iOS 4.0 and later.
     */
    public static final AVMetadataKeyCommon Software = new AVMetadataKeyCommon("Software");
    /*</constants>*/
    
    private static /*<name>*/AVMetadataKeyCommon/*</name>*/[] values = new /*<name>*/AVMetadataKeyCommon/*</name>*/[] {/*<value_list>*/Title, Creator, Subject, Description, Publisher, Contributor, CreationDate, LastModifiedDate, Type, Format, Identifier, Source, Language, Relation, Location, Copyrights, AlbumName, Author, Artist, Artwork, Make, Model, Software/*</value_list>*/};
    
    /*<name>*/AVMetadataKeyCommon/*</name>*/ (String getterName) {
        super(Values.class, getterName);
    }
    
    public static /*<name>*/AVMetadataKeyCommon/*</name>*/ valueOf(/*<type>*/NSString/*</type>*/ value) {
        for (/*<name>*/AVMetadataKeyCommon/*</name>*/ v : values) {
            if (v.value().equals(value)) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + value + " found in " 
            + /*<name>*/AVMetadataKeyCommon/*</name>*/.class.getName());
    }
    
    /*<methods>*//*</methods>*/
    
    /*<annotations>*/@Library("AVFoundation") @StronglyLinked/*</annotations>*/
    public static class Values {
    	static { Bro.bind(Values.class); }

        /*<values>*/
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyTitle", optional=true)
        public static native NSString Title();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyCreator", optional=true)
        public static native NSString Creator();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeySubject", optional=true)
        public static native NSString Subject();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyDescription", optional=true)
        public static native NSString Description();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyPublisher", optional=true)
        public static native NSString Publisher();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyContributor", optional=true)
        public static native NSString Contributor();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyCreationDate", optional=true)
        public static native NSString CreationDate();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyLastModifiedDate", optional=true)
        public static native NSString LastModifiedDate();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyType", optional=true)
        public static native NSString Type();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyFormat", optional=true)
        public static native NSString Format();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyIdentifier", optional=true)
        public static native NSString Identifier();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeySource", optional=true)
        public static native NSString Source();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyLanguage", optional=true)
        public static native NSString Language();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyRelation", optional=true)
        public static native NSString Relation();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyLocation", optional=true)
        public static native NSString Location();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyCopyrights", optional=true)
        public static native NSString Copyrights();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyAlbumName", optional=true)
        public static native NSString AlbumName();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyAuthor", optional=true)
        public static native NSString Author();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyArtist", optional=true)
        public static native NSString Artist();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyArtwork", optional=true)
        public static native NSString Artwork();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyMake", optional=true)
        public static native NSString Make();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeyModel", optional=true)
        public static native NSString Model();
        /**
         * @since Available in iOS 4.0 and later.
         */
        @GlobalValue(symbol="AVMetadataCommonKeySoftware", optional=true)
        public static native NSString Software();
        /*</values>*/
    }
}
