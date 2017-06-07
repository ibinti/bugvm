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
package com.bugvm.apple.coremedia;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.corevideo.*;
import com.bugvm.apple.audiotoolbox.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CMTimeMapping/*</name>*/ 
    extends /*<extends>*/Struct<CMTimeMapping>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CMTimeMappingPtr extends Ptr<CMTimeMapping, CMTimeMappingPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public CMTimeMapping() {}
    public CMTimeMapping(CMTimeRange source, CMTimeRange target) {
        this.setSource(source);
        this.setTarget(target);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    @StructMember(0) public native @ByVal CMTimeRange getSource();
    @StructMember(0) public native CMTimeMapping setSource(@ByVal CMTimeRange source);
    @StructMember(1) public native @ByVal CMTimeRange getTarget();
    @StructMember(1) public native CMTimeMapping setTarget(@ByVal CMTimeRange target);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
