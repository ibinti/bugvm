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
/*<visibility>*/public/*</visibility>*/ interface /*<name>*/UICollectionViewDelegate/*</name>*/ 
    /*<implements>*/extends UIScrollViewDelegate/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<methods>*/
    @Method(selector = "collectionView:shouldHighlightItemAtIndexPath:")
    boolean shouldHighlightItem(UICollectionView collectionView, NSIndexPath indexPath);
    @Method(selector = "collectionView:didHighlightItemAtIndexPath:")
    void didHighlightItem(UICollectionView collectionView, NSIndexPath indexPath);
    @Method(selector = "collectionView:didUnhighlightItemAtIndexPath:")
    void didUnhighlightItem(UICollectionView collectionView, NSIndexPath indexPath);
    @Method(selector = "collectionView:shouldSelectItemAtIndexPath:")
    boolean shouldSelectItem(UICollectionView collectionView, NSIndexPath indexPath);
    @Method(selector = "collectionView:shouldDeselectItemAtIndexPath:")
    boolean shouldDeselectItem(UICollectionView collectionView, NSIndexPath indexPath);
    @Method(selector = "collectionView:didSelectItemAtIndexPath:")
    void didSelectItem(UICollectionView collectionView, NSIndexPath indexPath);
    @Method(selector = "collectionView:didDeselectItemAtIndexPath:")
    void didDeselectItem(UICollectionView collectionView, NSIndexPath indexPath);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "collectionView:willDisplayCell:forItemAtIndexPath:")
    void willDisplayCell(UICollectionView collectionView, UICollectionViewCell cell, NSIndexPath indexPath);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "collectionView:willDisplaySupplementaryView:forElementKind:atIndexPath:")
    void willDisplaySupplementaryView(UICollectionView collectionView, UICollectionReusableView view, String elementKind, NSIndexPath indexPath);
    @Method(selector = "collectionView:didEndDisplayingCell:forItemAtIndexPath:")
    void didEndDisplayingCell(UICollectionView collectionView, UICollectionViewCell cell, NSIndexPath indexPath);
    @Method(selector = "collectionView:didEndDisplayingSupplementaryView:forElementOfKind:atIndexPath:")
    void didEndDisplayingSupplementaryView(UICollectionView collectionView, UICollectionReusableView view, String elementKind, NSIndexPath indexPath);
    @Method(selector = "collectionView:shouldShowMenuForItemAtIndexPath:")
    boolean shouldShowMenuForItem(UICollectionView collectionView, NSIndexPath indexPath);
    @Method(selector = "collectionView:canPerformAction:forItemAtIndexPath:withSender:")
    boolean canPerformAction(UICollectionView collectionView, Selector action, NSIndexPath indexPath, NSObject sender);
    @Method(selector = "collectionView:performAction:forItemAtIndexPath:withSender:")
    void performAction(UICollectionView collectionView, Selector action, NSIndexPath indexPath, NSObject sender);
    @Method(selector = "collectionView:transitionLayoutForOldLayout:newLayout:")
    UICollectionViewTransitionLayout getTransitionLayout(UICollectionView collectionView, UICollectionViewLayout fromLayout, UICollectionViewLayout toLayout);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "collectionView:targetIndexPathForMoveFromItemAtIndexPath:toProposedIndexPath:")
    NSIndexPath getTargetIndexPathForMoveFromItem(UICollectionView collectionView, NSIndexPath originalIndexPath, NSIndexPath proposedIndexPath);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "collectionView:targetContentOffsetForProposedContentOffset:")
    @ByVal CGPoint getTargetContentOffsetForProposedContentOffset(UICollectionView collectionView, @ByVal CGPoint proposedContentOffset);
    /*</methods>*/
    /*<adapter>*/
    /*</adapter>*/
}
