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
package com.bugvm.bindings.CoreAudio;

import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;

public class AudioBufferList extends Struct<AudioBufferList> {

    public static class AudioBufferListPtr extends Ptr<AudioBufferList, AudioBufferListPtr> {}
    public AudioBufferList() {}
    
    public int getBufferCount() {
        return getNumberBuffers();
    }
    
    public AudioBuffer getBuffer(int index) {
        if (index >= getBufferCount()) {
            throw new ArrayIndexOutOfBoundsException(index);
        }
        return getBuffers()[index];
        //return getBuffers0().next(index);
    }
//    public AudioBufferList setBuffer(int index, AudioBuffer buffer) {
//        return setBuffer(index, buffer.getHandle());
//    }
//    public AudioBufferList setBuffer(int index, long handle) {
//        if (index >= getBufferCount()) {
//            throw new ArrayIndexOutOfBoundsException(index);
//        }
//        getBuffers0().next(index).update(Struct.toStruct(AudioBuffer.class, handle));
//        return this;
//    }
    public AudioBuffer[] getBuffers() {
        //convert BytePtr to AudioBuffer?
        return getAudioBuffersPtr().as(AudioBuffer.class).toArray(getBufferCount());

        //return getBuffers0().toArray(getBufferCount());
    }
//    public AudioBufferList setBuffers(AudioBuffer[] buffers) {
//        this.setNumberBuffers(buffers.length);
//        getBuffers0().update(buffers);
//        return this;
//    }
    @StructMember(0) protected native int getNumberBuffers();
    @StructMember(0) protected native void setNumberBuffers(int numberBuffers);
    @StructMember(1) protected native @ByVal BytePtr getAudioBuffersPtr();
    //@StructMember(1) protected native void setBuffers0(@Array(1) AudioBuffer buffers);
}