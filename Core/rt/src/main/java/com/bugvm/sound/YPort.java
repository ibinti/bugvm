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

public class YPort extends YDataLine implements Port {
    //I know this is pretty bad, but for now this is what I can do.
    //
    //AudioFormat audioFormat;
    //Port.Info info;
    //
    public YPort() {
    
    }
    
    public YPort(Port.Info info) {
        super(info);
        this.info = info;
        //
        //System.out.println("returning from YPort(Line.Info info)");
    }
    
    public void open(int device, AudioFormat audioFormat, int BufferSize) throws LineUnavailableException {
        super.open();
        this.audioFormat = audioFormat;
        //
        int Encoding = 0;// convert this to int, audioFormat.getEncoding();
        int FrameRate = (int)audioFormat.getFrameRate();
        int BitsPerSample = audioFormat.getSampleSizeInBits();
        int Channels = audioFormat.getChannels();
        int FrameSize= audioFormat.getFrameSize();
        int SampleRate = (int)audioFormat.getSampleRate();
        boolean isBigEndian = audioFormat.isBigEndian();
        YNative.InputLineOpen(device,Encoding,FrameRate,BitsPerSample,Channels,FrameSize,SampleRate,isBigEndian,BufferSize);
    }
    
    public void open(Port.Info info, AudioFormat audioFormat, int BufferSize) throws LineUnavailableException {
        if(Boolean.getBoolean("YDEBUG")) {
            System.out.println("YPort open(Port.Info info, AudioFormat audioFormat, int BufferSize)");
        }
        super.open();
        this.audioFormat = audioFormat;
        //
        int device = 0;
        int Encoding = 0;// convert this to int, audioFormat.getEncoding();
        int FrameRate = (int)audioFormat.getFrameRate();
        int BitsPerSample = audioFormat.getSampleSizeInBits();
        int Channels = audioFormat.getChannels();
        int FrameSize= audioFormat.getFrameSize();
        int SampleRate = (int)audioFormat.getSampleRate();
        boolean isBigEndian = audioFormat.isBigEndian();
        //
        //I can get the numbers of ports using GetDeviceCount();
        //And I know the names from GetDeviceInfo(int device);
        //But can I assoiciate the name with Port.Info.* for sure?
        //the names from GetDeviceInfo(int device) on MacBook,
        //GetDeviceCount 3 -> device count
        //name: Built-in Microphone -> device = 0
        //name: Built-in Input -> device = 1
        //name: Built-in Output -> device = 2
        //
        //My question: how do you associate the string names with Port.Info.*?
        //PortAudio can return the number of Input lines and Outnupt lines with Device
        //So at least I know whether it has TargeDataLine, and/or SourceDataLine.
        //
        //
        if(info == Port.Info.COMPACT_DISC) {
            device = 0;
            YNative.InputLineOpen(device,Encoding,FrameRate,BitsPerSample,Channels,FrameSize,SampleRate,isBigEndian,BufferSize);
            //
            return;  
        }
        //
        if(info == Port.Info.HEADPHONE) {
            device = 2;
            //
            YNative.OutputLineOpen(device,Encoding,FrameRate,BitsPerSample,Channels,FrameSize,SampleRate,isBigEndian,BufferSize);
            //
            return; 
        }
        //
        if(info == Port.Info.LINE_IN) {
            device = 1;
            YNative.InputLineOpen(device,Encoding,FrameRate,BitsPerSample,Channels,FrameSize,SampleRate,isBigEndian,BufferSize);
            //
            return; 
        }
        //
        if(info == Port.Info.LINE_OUT) {
            device = 2;
            YNative.OutputLineOpen(device,Encoding,FrameRate,BitsPerSample,Channels,FrameSize,SampleRate,isBigEndian,BufferSize);
            //
            return; 
        }
        //
        if(info == Port.Info.MICROPHONE) {
            device = 0;
            YNative.InputLineOpen(device,Encoding,FrameRate,BitsPerSample,Channels,FrameSize,SampleRate,isBigEndian,BufferSize);
            //
            return; 
        }
        //
        if(info == Port.Info.SPEAKER) {
            device = 2;
            YNative.OutputLineOpen(device,Encoding,FrameRate,BitsPerSample,Channels,FrameSize,SampleRate,isBigEndian,BufferSize);
            //
            return; 
        }
    }
}