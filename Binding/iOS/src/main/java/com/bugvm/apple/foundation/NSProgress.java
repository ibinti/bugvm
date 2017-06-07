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
 * @since Available in iOS 7.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSProgress/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSProgressPtr extends Ptr<NSProgress, NSProgressPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSProgress.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSProgress() {}
    protected NSProgress(SkipInit skipInit) { super(skipInit); }
    public NSProgress(NSProgress parentProgressOrNil, NSProgressUserInfo userInfoOrNil) { super((SkipInit) null); initObject(init(parentProgressOrNil, userInfoOrNil)); }
    public NSProgress(long unitCount) { super(create(unitCount)); retain(getHandle()); }
    /**
     * @since Available in iOS 9.0 and later.
     */
    public NSProgress(long unitCount, NSProgress parent, long portionOfParentTotalUnitCount) { super(create(unitCount, parent, portionOfParentTotalUnitCount)); retain(getHandle()); }
    /*</constructors>*/
    /**
     * @since Available in iOS 9.0 and later.
     */
    public NSProgress(long unitCount, boolean discrete) {
        super(discrete ? createDiscrete(unitCount) : create(unitCount));
        retain(getHandle());
    }
    /*<properties>*/
    @Property(selector = "totalUnitCount")
    public native long getTotalUnitCount();
    @Property(selector = "setTotalUnitCount:")
    public native void setTotalUnitCount(long v);
    @Property(selector = "completedUnitCount")
    public native long getCompletedUnitCount();
    @Property(selector = "setCompletedUnitCount:")
    public native void setCompletedUnitCount(long v);
    @Property(selector = "localizedDescription")
    public native String getLocalizedDescription();
    @Property(selector = "setLocalizedDescription:")
    public native void setLocalizedDescription(String v);
    @Property(selector = "localizedAdditionalDescription")
    public native String getLocalizedAdditionalDescription();
    @Property(selector = "setLocalizedAdditionalDescription:")
    public native void setLocalizedAdditionalDescription(String v);
    @Property(selector = "isCancellable")
    public native boolean isCancellable();
    @Property(selector = "setCancellable:")
    public native void setCancellable(boolean v);
    @Property(selector = "isPausable")
    public native boolean isPausable();
    @Property(selector = "setPausable:")
    public native void setPausable(boolean v);
    @Property(selector = "isCancelled")
    public native boolean isCancelled();
    @Property(selector = "isPaused")
    public native boolean isPaused();
    @Property(selector = "cancellationHandler")
    public native @Block Runnable getCancellationHandler();
    @Property(selector = "setCancellationHandler:")
    public native void setCancellationHandler(@Block Runnable v);
    @Property(selector = "pausingHandler")
    public native @Block Runnable getPausingHandler();
    @Property(selector = "setPausingHandler:")
    public native void setPausingHandler(@Block Runnable v);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "resumingHandler")
    public native @Block Runnable getResumingHandler();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Property(selector = "setResumingHandler:")
    public native void setResumingHandler(@Block Runnable v);
    @Property(selector = "isIndeterminate")
    public native boolean isIndeterminate();
    @Property(selector = "fractionCompleted")
    public native double getFractionCompleted();
    @Property(selector = "userInfo")
    public native NSProgressUserInfo getUserInfo();
    @Property(selector = "kind")
    public native NSProgressKind getKind();
    @Property(selector = "setKind:")
    public native void setKind(NSProgressKind v);
    /*</properties>*/
    /*<members>*//*</members>*/
    public void putUserInfoObject(String key, NSObject value) {
        setUserInfoObject(value, new NSString(key));
    }
    public void putUserInfoObject(NSProgressUserInfoKey key, NSObject value) {
        setUserInfoObject(value, key.value());
    }
    /*<methods>*/
    @Method(selector = "initWithParent:userInfo:")
    protected native @Pointer long init(NSProgress parentProgressOrNil, NSProgressUserInfo userInfoOrNil);
    @Method(selector = "becomeCurrentWithPendingUnitCount:")
    public native void becomeCurrent(long unitCount);
    @Method(selector = "resignCurrent")
    public native void resignCurrent();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "addChild:withPendingUnitCount:")
    public native void addChild(NSProgress child, long inUnitCount);
    @Method(selector = "setUserInfoObject:forKey:")
    protected native void setUserInfoObject(NSObject objectOrNil, NSString key);
    @Method(selector = "cancel")
    public native void cancel();
    @Method(selector = "pause")
    public native void pause();
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "resume")
    public native void resume();
    @Method(selector = "currentProgress")
    public static native NSProgress getCurrentProgress();
    @Method(selector = "progressWithTotalUnitCount:")
    protected static native @Pointer long create(long unitCount);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "discreteProgressWithTotalUnitCount:")
    protected static native @Pointer long createDiscrete(long unitCount);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "progressWithTotalUnitCount:parent:pendingUnitCount:")
    protected static native @Pointer long create(long unitCount, NSProgress parent, long portionOfParentTotalUnitCount);
    /*</methods>*/
}
