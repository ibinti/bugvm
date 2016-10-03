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
package com.bugvm.ios.AVFoundation;

/*<imports>*/

import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 4.1 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("AVFoundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AVQueuePlayer/*</name>*/ 
    extends /*<extends>*/AVPlayer/*</extends>*/
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AVQueuePlayerPtr extends Ptr<AVQueuePlayer, AVQueuePlayerPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(AVQueuePlayer.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AVQueuePlayer() {}
    protected AVQueuePlayer(SkipInit skipInit) { super(skipInit); }
    public AVQueuePlayer(NSArray<com.bugvm.ios.AVFoundation.AVPlayerItem> items) { super((SkipInit) null); initObject(init(items)); }
    /*</constructors>*/
    /*<properties>*/
    
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithItems:")
    protected native @Pointer long init(NSArray<com.bugvm.ios.AVFoundation.AVPlayerItem> items);
    @Method(selector = "items")
    public native NSArray<com.bugvm.ios.AVFoundation.AVPlayerItem> getItems();
    @Method(selector = "advanceToNextItem")
    public native void advanceToNextItem();
    @Method(selector = "canInsertItem:afterItem:")
    public native boolean canInsertItem(com.bugvm.ios.AVFoundation.AVPlayerItem item, com.bugvm.ios.AVFoundation.AVPlayerItem afterItem);
    @Method(selector = "insertItem:afterItem:")
    public native void insertItem(com.bugvm.ios.AVFoundation.AVPlayerItem item, com.bugvm.ios.AVFoundation.AVPlayerItem afterItem);
    @Method(selector = "removeItem:")
    public native void removeItem(com.bugvm.ios.AVFoundation.AVPlayerItem item);
    @Method(selector = "removeAllItems")
    public native void removeAllItems();
    /*</methods>*/
}
