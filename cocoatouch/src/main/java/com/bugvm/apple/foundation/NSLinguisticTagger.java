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
 * @since Available in iOS 5.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSLinguisticTagger/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSLinguisticTaggerPtr extends Ptr<NSLinguisticTagger, NSLinguisticTaggerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSLinguisticTagger.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSLinguisticTagger() {}
    protected NSLinguisticTagger(SkipInit skipInit) { super(skipInit); }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public NSLinguisticTagger(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsListMarshaler.class) List<NSLinguisticTagScheme> tagSchemes, NSLinguisticTaggerOptions opts) { super((SkipInit) null); initObject(init(tagSchemes, opts)); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "tagSchemes")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsListMarshaler.class) List<NSLinguisticTagScheme> getTagSchemes();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "string")
    public native String getString();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Property(selector = "setString:")
    public native void setString(String v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    public List<NSLinguisticTag> getTags(NSRange range, NSLinguisticTagScheme tagScheme, NSLinguisticTaggerOptions opts) {
        return getTags(range, tagScheme, opts, null);
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public List<NSRange> getTagRanges(NSRange range, NSLinguisticTagScheme tagScheme, NSLinguisticTaggerOptions opts) {
        NSArray.NSArrayPtr<NSValue> ptr = new NSArray.NSArrayPtr<>();
        getTags(range, tagScheme, opts, ptr);
        List<NSRange> list = new ArrayList<>();
        for (NSValue val : ptr.get()) {
            list.add(val.rangeValue());
        }
        return list;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public List<NSLinguisticTag> getPossibleTags(@MachineSizedUInt long charIndex, NSLinguisticTagScheme tagScheme, NSRange tokenRange, NSRange sentenceRange) {
        return getPossibleTags(charIndex, tagScheme, tokenRange, sentenceRange, null);
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public List<Long> getPossibleTagScores(@MachineSizedUInt long charIndex, NSLinguisticTagScheme tagScheme, NSRange tokenRange, NSRange sentenceRange) {
        NSArray.NSArrayPtr<NSNumber> ptr = new NSArray.NSArrayPtr<>();
        getPossibleTags(charIndex, tagScheme, tokenRange, sentenceRange, ptr);
        List<Long> list = new ArrayList<>();
        for (NSNumber val : ptr.get()) {
            list.add(val.longValue());
        }
        return list;
    }
    /*<methods>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "initWithTagSchemes:options:")
    protected native @Pointer long init(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsListMarshaler.class) List<NSLinguisticTagScheme> tagSchemes, NSLinguisticTaggerOptions opts);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "setOrthography:range:")
    public native void setOrthography(NSOrthography orthography, @ByVal NSRange range);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "orthographyAtIndex:effectiveRange:")
    public native NSOrthography getOrthography(@MachineSizedUInt long charIndex, NSRange effectiveRange);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "stringEditedInRange:changeInLength:")
    public native void stringEditedInRange(@ByVal NSRange newRange, @MachineSizedSInt long delta);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "enumerateTagsInRange:scheme:options:usingBlock:")
    public native void enumerateTagsInRange(@ByVal NSRange range, NSLinguisticTagScheme tagScheme, NSLinguisticTaggerOptions opts, @Block("(,@ByVal,@ByVal,)") VoidBlock4<NSLinguisticTag, NSRange, NSRange, BooleanPtr> block);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "sentenceRangeForRange:")
    public native @ByVal NSRange getSentenceRange(@ByVal NSRange range);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "tagAtIndex:scheme:tokenRange:sentenceRange:")
    public native String getTag(@MachineSizedUInt long charIndex, NSLinguisticTagScheme tagScheme, NSRange tokenRange, NSRange sentenceRange);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "tagsInRange:scheme:options:tokenRanges:")
    protected native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsListMarshaler.class) List<NSLinguisticTag> getTags(@ByVal NSRange range, NSLinguisticTagScheme tagScheme, NSLinguisticTaggerOptions opts, NSArray.NSArrayPtr tokenRanges);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "possibleTagsAtIndex:scheme:tokenRange:sentenceRange:scores:")
    protected native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsListMarshaler.class) List<NSLinguisticTag> getPossibleTags(@MachineSizedUInt long charIndex, NSLinguisticTagScheme tagScheme, NSRange tokenRange, NSRange sentenceRange, NSArray.NSArrayPtr scores);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Method(selector = "availableTagSchemesForLanguage:")
    public static native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsListMarshaler.class) List<NSLinguisticTagScheme> getAvailableTagSchemes(String language);
    /*</methods>*/
}
