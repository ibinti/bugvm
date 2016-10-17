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
package com.bugvm.apple.audiotoolbox;

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
import com.bugvm.apple.audiounit.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.coremidi.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CAFFileHeader/*</name>*/ 
    extends /*<extends>*/Struct<CAFFileHeader>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CAFFileHeaderPtr extends Ptr<CAFFileHeader, CAFFileHeaderPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    public CAFFileHeader() {
        this.setFileType(AudioFileType.valueOf(CAFFileHeaderInfo.Type.value()));
        this.setFileVersion((short) CAFFileHeaderInfo.Version_Initial.value());
    }
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*/
    
    /*</members>*/
    @StructMember(0) public native AudioFileType getFileType();
    @StructMember(0) private native CAFFileHeader setFileType(AudioFileType fileType);
    @StructMember(1) public native short getFileVersion();
    @StructMember(1) private native CAFFileHeader setFileVersion(short fileVersion);
    @StructMember(2) public native short getFileFlags();
    @StructMember(2) private native CAFFileHeader setFileFlags(short fileFlags);
    /*<methods>*//*</methods>*/
}
