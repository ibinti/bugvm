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
package com.bugvm.apple.mapkit;

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
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.corelocation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 7.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MapKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MKMapSnapshotter/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MKMapSnapshotterPtr extends Ptr<MKMapSnapshotter, MKMapSnapshotterPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MKMapSnapshotter.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MKMapSnapshotter() {}
    protected MKMapSnapshotter(SkipInit skipInit) { super(skipInit); }
    public MKMapSnapshotter(MKMapSnapshotOptions options) { super((SkipInit) null); initObject(init(options)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "isLoading")
    public native boolean isLoading();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "initWithOptions:")
    protected native @Pointer long init(MKMapSnapshotOptions options);
    @Method(selector = "startWithCompletionHandler:")
    public native void start(@Block VoidBlock2<MKMapSnapshot, NSError> completionHandler);
    @WeaklyLinked
    @Method(selector = "startWithQueue:completionHandler:")
    public native void start(DispatchQueue queue, @Block VoidBlock2<MKMapSnapshot, NSError> completionHandler);
    @Method(selector = "cancel")
    public native void cancel();
    /*</methods>*/
}
