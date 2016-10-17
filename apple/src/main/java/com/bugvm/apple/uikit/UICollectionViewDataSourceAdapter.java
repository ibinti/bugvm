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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/UICollectionViewDataSourceAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements UICollectionViewDataSource/*</implements>*/ {

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
    @NotImplemented("collectionView:numberOfItemsInSection:")
    public @MachineSizedSInt long getNumberOfItemsInSection(UICollectionView collectionView, @MachineSizedSInt long section) { return 0; }
    @NotImplemented("collectionView:cellForItemAtIndexPath:")
    public UICollectionViewCell getCellForItem(UICollectionView collectionView, NSIndexPath indexPath) { return null; }
    @NotImplemented("numberOfSectionsInCollectionView:")
    public @MachineSizedSInt long getNumberOfSections(UICollectionView collectionView) { return 0; }
    @NotImplemented("collectionView:viewForSupplementaryElementOfKind:atIndexPath:")
    public UICollectionReusableView getViewForSupplementaryElement(UICollectionView collectionView, String kind, NSIndexPath indexPath) { return null; }
    /**
     * @since Available in iOS 9.0 and later.
     */
    @NotImplemented("collectionView:canMoveItemAtIndexPath:")
    public boolean canMoveItemAt(UICollectionView collectionView, NSIndexPath indexPath) { return false; }
    /**
     * @since Available in iOS 9.0 and later.
     */
    @NotImplemented("collectionView:moveItemAtIndexPath:toIndexPath:")
    public void moveItemAt(UICollectionView collectionView, NSIndexPath sourceIndexPath, NSIndexPath destinationIndexPath) {}
    /*</methods>*/
}
