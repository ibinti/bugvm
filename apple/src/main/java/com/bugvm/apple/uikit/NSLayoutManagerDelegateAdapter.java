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
package com.bugvm.apple.uikit;

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
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.corelocation.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSLayoutManagerDelegateAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSLayoutManagerDelegate/*</implements>*/ {

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
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("layoutManager:shouldGenerateGlyphs:properties:characterIndexes:font:forGlyphRange:")
    public @MachineSizedUInt long shouldGenerateGlyphs(NSLayoutManager layoutManager, ShortPtr glyphs, MachineSizedSIntPtr props, MachineSizedUIntPtr charIndexes, UIFont aFont, @ByVal NSRange glyphRange) { return 0; }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("layoutManager:lineSpacingAfterGlyphAtIndex:withProposedLineFragmentRect:")
    public @MachineSizedFloat double getLineSpacingAfterGlyph(NSLayoutManager layoutManager, @MachineSizedUInt long glyphIndex, @ByVal CGRect rect) { return 0; }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("layoutManager:paragraphSpacingBeforeGlyphAtIndex:withProposedLineFragmentRect:")
    public @MachineSizedFloat double getParagraphSpacingBeforeGlyph(NSLayoutManager layoutManager, @MachineSizedUInt long glyphIndex, @ByVal CGRect rect) { return 0; }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("layoutManager:paragraphSpacingAfterGlyphAtIndex:withProposedLineFragmentRect:")
    public @MachineSizedFloat double getParagraphSpacingAfterGlyph(NSLayoutManager layoutManager, @MachineSizedUInt long glyphIndex, @ByVal CGRect rect) { return 0; }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("layoutManager:shouldUseAction:forControlCharacterAtIndex:")
    public NSControlCharacterAction shouldUseAction(NSLayoutManager layoutManager, NSControlCharacterAction action, @MachineSizedUInt long charIndex) { return null; }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("layoutManager:shouldBreakLineByWordBeforeCharacterAtIndex:")
    public boolean shouldBreakLineByWordBeforeCharacter(NSLayoutManager layoutManager, @MachineSizedUInt long charIndex) { return false; }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("layoutManager:shouldBreakLineByHyphenatingBeforeCharacterAtIndex:")
    public boolean shouldBreakLineByHyphenatingBeforeCharacter(NSLayoutManager layoutManager, @MachineSizedUInt long charIndex) { return false; }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("layoutManager:boundingBoxForControlGlyphAtIndex:forTextContainer:proposedLineFragment:glyphPosition:characterIndex:")
    public @ByVal CGRect getBoundingBoxForControlGlyph(NSLayoutManager layoutManager, @MachineSizedUInt long glyphIndex, NSTextContainer textContainer, @ByVal CGRect proposedRect, @ByVal CGPoint glyphPosition, @MachineSizedUInt long charIndex) { return null; }
    /**
     * @since Available in iOS 9.0 and later.
     */
    @NotImplemented("layoutManager:shouldSetLineFragmentRect:lineFragmentUsedRect:baselineOffset:inTextContainer:forGlyphRange:")
    public boolean shouldSetLineFragmentRect(NSLayoutManager layoutManager, CGRect lineFragmentRect, CGRect lineFragmentUsedRect, MachineSizedFloatPtr baselineOffset, NSTextContainer textContainer, @ByVal NSRange glyphRange) { return false; }
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("layoutManagerDidInvalidateLayout:")
    public void didInvalidateLayout(NSLayoutManager sender) {}
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("layoutManager:didCompleteLayoutForTextContainer:atEnd:")
    public void didCompleteLayout(NSLayoutManager layoutManager, NSTextContainer textContainer, boolean layoutFinishedFlag) {}
    /**
     * @since Available in iOS 7.0 and later.
     */
    @NotImplemented("layoutManager:textContainer:didChangeGeometryFromSize:")
    public void didChangeGeometry(NSLayoutManager layoutManager, NSTextContainer textContainer, @ByVal CGSize oldSize) {}
    /*</methods>*/
}
