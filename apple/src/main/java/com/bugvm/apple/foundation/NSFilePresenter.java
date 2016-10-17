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
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ interface /*<name>*/NSFilePresenter/*</name>*/ 
    /*<implements>*/extends NSObjectProtocol/*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<properties>*/
    @Property(selector = "presentedItemURL")
    NSURL getPresentedItemURL();
    @Property(selector = "presentedItemOperationQueue")
    NSOperationQueue getPresentedItemOperationQueue();
    /*</properties>*/
    /*<methods>*/
    @Method(selector = "relinquishPresentedItemToReader:")
    void relinquishPresentedItemToReader(@Block("(@Block)") VoidBlock1<Runnable> reader);
    @Method(selector = "relinquishPresentedItemToWriter:")
    void relinquishPresentedItemToWriter(@Block("(@Block)") VoidBlock1<Runnable> writer);
    @Method(selector = "savePresentedItemChangesWithCompletionHandler:")
    void savePresentedItemChanges(@Block VoidBlock1<NSError> completionHandler);
    @Method(selector = "accommodatePresentedItemDeletionWithCompletionHandler:")
    void accommodatePresentedItemDeletion(@Block VoidBlock1<NSError> completionHandler);
    @Method(selector = "presentedItemDidMoveToURL:")
    void presentedItemDidMoveToURL(NSURL newURL);
    @Method(selector = "presentedItemDidChange")
    void presentedItemDidChange();
    @Method(selector = "presentedItemDidGainVersion:")
    void presentedItemDidGainVersion(NSFileVersion version);
    @Method(selector = "presentedItemDidLoseVersion:")
    void presentedItemDidLoseVersion(NSFileVersion version);
    @Method(selector = "presentedItemDidResolveConflictVersion:")
    void presentedItemDidResolveConflictVersion(NSFileVersion version);
    @Method(selector = "accommodatePresentedSubitemDeletionAtURL:completionHandler:")
    void accommodatePresentedSubitemDeletionAtURL(NSURL url, @Block VoidBlock1<NSError> completionHandler);
    @Method(selector = "presentedSubitemDidAppearAtURL:")
    void presentedSubitemDidAppearAtURL(NSURL url);
    @Method(selector = "presentedSubitemAtURL:didMoveToURL:")
    void presentedSubitemAtURLDidMoveToURL(NSURL oldURL, NSURL newURL);
    @Method(selector = "presentedSubitemDidChangeAtURL:")
    void presentedSubitemDidChangeAtURL(NSURL url);
    @Method(selector = "presentedSubitemAtURL:didGainVersion:")
    void presentedSubitemAtURLDidGainVersion(NSURL url, NSFileVersion version);
    @Method(selector = "presentedSubitemAtURL:didLoseVersion:")
    void presentedSubitemAtURLDidLoseVersion(NSURL url, NSFileVersion version);
    @Method(selector = "presentedSubitemAtURL:didResolveConflictVersion:")
    void presentedSubitemAtURLDidResolveConflictVersion(NSURL url, NSFileVersion version);
    /*</methods>*/
    /*<adapter>*/
    /*</adapter>*/
}
