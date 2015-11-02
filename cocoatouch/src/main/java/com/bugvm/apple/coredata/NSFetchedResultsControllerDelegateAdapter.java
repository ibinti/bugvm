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
package com.bugvm.apple.coredata;

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
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSFetchedResultsControllerDelegateAdapter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSFetchedResultsControllerDelegate/*</implements>*/ {

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
    @NotImplemented("controller:didChangeObject:atIndexPath:forChangeType:newIndexPath:")
    public void didChangeObject(NSFetchedResultsController controller, NSObject anObject, NSIndexPath indexPath, NSFetchedResultsChangeType type, NSIndexPath newIndexPath) {}
    @NotImplemented("controller:didChangeSection:atIndex:forChangeType:")
    public void didChangeSection(NSFetchedResultsController controller, NSFetchedResultsSectionInfo sectionInfo, @MachineSizedUInt long sectionIndex, NSFetchedResultsChangeType type) {}
    @NotImplemented("controllerWillChangeContent:")
    public void willChangeContent(NSFetchedResultsController controller) {}
    @NotImplemented("controllerDidChangeContent:")
    public void didChangeContent(NSFetchedResultsController controller) {}
    /**
     * @since Available in iOS 4.0 and later.
     */
    @NotImplemented("controller:sectionIndexTitleForSectionName:")
    public String getSectionIndexTitle(NSFetchedResultsController controller, String sectionName) { return null; }
    /*</methods>*/
}
