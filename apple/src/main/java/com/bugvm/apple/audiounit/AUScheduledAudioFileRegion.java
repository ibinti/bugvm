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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/AUScheduledAudioFileRegion/*</name>*/ 
    extends /*<extends>*/Struct<AUScheduledAudioFileRegion>/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public interface CompletionListener {
        void onComplete(AUScheduledAudioFileRegion slice, OSStatus result);
    }
    
    private static java.util.concurrent.atomic.AtomicLong callbackId = new java.util.concurrent.atomic.AtomicLong(1);
    
    private static LongMap<CompletionListener> completionCallbacks = new LongMap<>();
    private static final java.lang.reflect.Method cbComplete;
    
    static {
        try {
            cbComplete = AUScheduledAudioFileRegion.class.getDeclaredMethod("cbComplete", Long.TYPE, AUScheduledAudioFileRegion.class, OSStatus.class);
        } catch (Throwable e) {
            throw new Error(e);
        }
    }
    
    /*<ptr>*/public static class AUScheduledAudioFileRegionPtr extends Ptr<AUScheduledAudioFileRegion, AUScheduledAudioFileRegionPtr> {}/*</ptr>*/
    /*<bind>*/
    /*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public AUScheduledAudioFileRegion() {}
    public AUScheduledAudioFileRegion(AudioTimeStamp timeStamp, AudioFile audioFile, int loopCount, long startFrame, int framesToPlay) {
        this.setTimeStamp(timeStamp);
        this.setAudioFile(audioFile);
        this.setLoopCount(loopCount);
        this.setStartFrame(startFrame);
        this.setFramesToPlay(framesToPlay);
    }
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    @Callback
    private static void cbComplete(@Pointer long userData, AUScheduledAudioFileRegion slice, OSStatus result) {
        synchronized (completionCallbacks) {
            completionCallbacks.get(userData).onComplete(slice, result);
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
    @StructMember(0) public native AUScheduledAudioFileRegion setTimeStamp(@ByVal AudioTimeStamp timeStamp);
    @StructMember(1) private native FunctionPtr getCompletionProc();
    @StructMember(1) private native AUScheduledAudioFileRegion setCompletionProc(FunctionPtr completionProc);
    @StructMember(2) private native @Pointer long getCompletionProcUserData();
    @StructMember(2) private native AUScheduledAudioFileRegion setCompletionProcUserData(@Pointer long completionProcUserData);
    @StructMember(3) public native AudioFile getAudioFile();
    @StructMember(3) public native AUScheduledAudioFileRegion setAudioFile(AudioFile audioFile);
    @StructMember(4) public native int getLoopCount();
    @StructMember(4) public native AUScheduledAudioFileRegion setLoopCount(int loopCount);
    @StructMember(5) public native long getStartFrame();
    @StructMember(5) public native AUScheduledAudioFileRegion setStartFrame(long startFrame);
    @StructMember(6) public native int getFramesToPlay();
    @StructMember(6) public native AUScheduledAudioFileRegion setFramesToPlay(int framesToPlay);
    /*</members>*/
    /*<methods>*//*</methods>*/
}
