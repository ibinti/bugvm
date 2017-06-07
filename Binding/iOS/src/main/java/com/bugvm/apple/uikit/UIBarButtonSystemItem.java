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
/*<annotations>*/@Marshaler(ValuedEnum.AsMachineSizedSIntMarshaler.class)/*</annotations>*/
public enum /*<name>*/UIBarButtonSystemItem/*</name>*/ implements ValuedEnum {
    /*<values>*/
    Done(0L),
    Cancel(1L),
    Edit(2L),
    Save(3L),
    Add(4L),
    FlexibleSpace(5L),
    FixedSpace(6L),
    Compose(7L),
    Reply(8L),
    Action(9L),
    Organize(10L),
    Bookmarks(11L),
    Search(12L),
    Refresh(13L),
    Stop(14L),
    Camera(15L),
    Trash(16L),
    Play(17L),
    Pause(18L),
    Rewind(19L),
    FastForward(20L),
    /**
     * @since Available in iOS 3.0 and later.
     */
    Undo(21L),
    /**
     * @since Available in iOS 3.0 and later.
     */
    Redo(22L),
    /**
     * @since Available in iOS 4.0 and later.
     */
    PageCurl(23L);
    /*</values>*/

    private final long n;

    private /*<name>*/UIBarButtonSystemItem/*</name>*/(long n) { this.n = n; }
    public long value() { return n; }
    public static /*<name>*/UIBarButtonSystemItem/*</name>*/ valueOf(long n) {
        for (/*<name>*/UIBarButtonSystemItem/*</name>*/ v : values()) {
            if (v.n == n) {
                return v;
            }
        }
        throw new IllegalArgumentException("No constant with value " + n + " found in " 
            + /*<name>*/UIBarButtonSystemItem/*</name>*/.class.getName());
    }
}
