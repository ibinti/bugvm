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
package com.bugvm.apple.newsstandkit;

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
/**
 * @since Available in iOS 5.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("NewsstandKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NKLibrary/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NKLibraryPtr extends Ptr<NKLibrary, NKLibraryPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NKLibrary.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NKLibrary() {}
    protected NKLibrary(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "issues")
    public native NSArray<NKIssue> getIssues();
    @Property(selector = "downloadingAssets")
    public native NSArray<NKAssetDownload> getDownloadingAssets();
    @Property(selector = "currentlyReadingIssue")
    public native NKIssue getCurrentlyReadingIssue();
    @Property(selector = "setCurrentlyReadingIssue:")
    public native void setCurrentlyReadingIssue(NKIssue v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "issueWithName:")
    public native NKIssue getIssue(String name);
    @Method(selector = "addIssueWithName:date:")
    public native NKIssue addIssue(String name, NSDate date);
    @Method(selector = "removeIssue:")
    public native void removeIssue(NKIssue issue);
    @Method(selector = "sharedLibrary")
    public static native NKLibrary getSharedLibrary();
    /*</methods>*/
}
