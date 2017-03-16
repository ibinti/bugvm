/*
 * Copyright (C) 2017 BugVM
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
package com.bugvm.sound;

import javax.sound.sampled.*;
import javax.sound.sampled.spi.*;

public class YMixerProvider extends MixerProvider {
    public YMixerProvider() {
    //
    }
    
    @Override
    public boolean isMixerSupported(Mixer.Info info) {
        if(info.getName().equals("BugVMSound")) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public Mixer.Info[] getMixerInfo() {
        Mixer.Info[] info = new Mixer.Info[1];
        //
        //i think this should return only Info, but i do not know how to do it yet.
        //so for now, return new YMixer
        info[0] = (Mixer.Info)new YMixer("BugVMSound","BugVMSound","BugVMSound","BugVMSound");
        //
        return info;
    }
    
    @Override
    public Mixer getMixer(Mixer.Info info) {
        if(info.getName().equals("BugVMSound")) {
            return (Mixer)new YMixer("BugVMSound","BugVMSound","BugVMSound","BugVMSound");
        } else {
            return null;
        }
    }    
}