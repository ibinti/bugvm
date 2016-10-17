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
package com.bugvm.apple.audiounit;

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
import com.bugvm.apple.audiotoolbox.*;
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.coreaudio.*;
import com.bugvm.apple.uikit.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*//*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AUScheduledAudioSlice/*</name>*/ 
    extends /*<extends>*/Struct<AUScheduledAudioSlice>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class AUScheduledAudioSlicePtr extends Ptr<AUScheduledAudioSlice, AUScheduledAudioSlicePtr> {}/*</ptr>*/

    public interface CompletionListener {
        void onComplete(AUScheduledAudioSlice slice);
    }
    
    private static java.util.concurrent.atomic.AtomicLong callbackId = new java.util.concurrent.atomic.AtomicLong(1);
    
    private static LongMap<CompletionListener> completionCallbacks = new LongMap<>();
    private static final java.lang.reflect.Method cbComplete;
    
    static {
        try {
            cbComplete = AUScheduledAudioSlice.class.getDeclaredMethod("cbComplete", Long.TYPE, AUScheduledAudioSlice.class);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AUScheduledAudioSlice() {}
    public AUScheduledAudioSlice(AudioTimeStamp timeStamp, AUScheduledAudioSlice flags, int numberFrames, AudioBufferList bufferList) {
        this.setTimeStamp(timeStamp);
        this.setFlags(flags);
        this.setNumberFrames(numberFrames);
        this.setBufferList(bufferList);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    @Callback
    private static void cbComplete(@Pointer long userData, AUScheduledAudioSlice slice) {
        synchronized (completionCallbacks) {
            completionCallbacks.get(userData).onComplete(slice);
        }
    }
    
    public CompletionListener getCompletionListener() {
        synchronized (completionCallbacks) {
            return completionCallbacks.get(getCompletionProcUserData());
        }
    }
    public void setCompletionListener(CompletionListener listener) {
        long cid = getCompletionProcUserData();
        if (listener == null) {
            setCompletionProc(null);
            setCompletionProcUserData(0);
            if (cid > 0) {
                synchronized (completionCallbacks) {
                    completionCallbacks.remove(cid);
                }
            }
        } else {
            if (cid == 0) {
                cid = callbackId.getAndIncrement();
                setCompletionProcUserData(cid);
                setCompletionProc(new FunctionPtr(cbComplete));
            }
            synchronized (completionCallbacks) {
                completionCallbacks.put(cid, listener);
            }
        }
    }
    /*<members>*/
    @StructMember(0) public native @ByVal AudioTimeStamp getTimeStamp();
    @StructMember(0) public native AUScheduledAudioSlice setTimeStamp(@ByVal AudioTimeStamp timeStamp);
    @StructMember(1) private native FunctionPtr getCompletionProc();
    @StructMember(1) private native AUScheduledAudioSlice setCompletionProc(FunctionPtr completionProc);
    @StructMember(2) private native @Pointer long getCompletionProcUserData();
    @StructMember(2) private native AUScheduledAudioSlice setCompletionProcUserData(@Pointer long completionProcUserData);
    @StructMember(3) public native AUScheduledAudioSlice getFlags();
    @StructMember(3) public native AUScheduledAudioSlice setFlags(AUScheduledAudioSlice flags);
    @StructMember(4) private native int getReserved();
    @StructMember(4) private native AUScheduledAudioSlice setReserved(int reserved);
    @StructMember(5) private native VoidPtr getReserved2();
    @StructMember(5) private native AUScheduledAudioSlice setReserved2(VoidPtr reserved2);
    @StructMember(6) public native int getNumberFrames();
    @StructMember(6) public native AUScheduledAudioSlice setNumberFrames(int numberFrames);
    @StructMember(7) public native AudioBufferList getBufferList();
    @StructMember(7) public native AUScheduledAudioSlice setBufferList(AudioBufferList bufferList);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
