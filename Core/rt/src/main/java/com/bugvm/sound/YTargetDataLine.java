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

public class YTargetDataLine extends YDataLine implements TargetDataLine {
    public YTargetDataLine() {
        if(Boolean.getBoolean("YDEBUG")) {
            System.out.println("YTargetDataLine()");
        }
    }
    
    public YTargetDataLine(Line.Info info) {
        super(info);
        if(Boolean.getBoolean("YDEBUG")) {
            System.out.println("YTargetDataLine(Line.Info info)");
        }
    }
    
    @Override
    public void open(AudioFormat audioFormat, int BufferSize) throws LineUnavailableException {
        super.open(audioFormat,BufferSize);
        //
        int Encoding = 0;// convert this to int, audioFormat.getEncoding();
        int FrameRate = (int)audioFormat.getFrameRate();
        int BitsPerSample = audioFormat.getSampleSizeInBits();
        int Channels = audioFormat.getChannels();
        int FrameSize= audioFormat.getFrameSize();
        int SampleRate = (int)audioFormat.getSampleRate();
        boolean isBigEndian = audioFormat.isBigEndian();
        int device = YNative.GetDefaultInputDevice();
        YNative.InputLineOpen(device,Encoding,FrameRate,BitsPerSample,Channels,FrameSize,SampleRate,isBigEndian,BufferSize);
        //
        if(Boolean.getBoolean("YDEBUG")) {
            System.out.println("YTargetDataLine.open(AudioFormat audioFormat, int BufferSize)");
        }
    }
    //
    @Override
    public void open(AudioFormat audioFormat) throws LineUnavailableException {
        open(audioFormat, 1024*4);
        if(Boolean.getBoolean("YDEBUG")) {
            System.out.println("YTargetDataLine.open(AudioFormat audioFormat)");
        }
    }
    //
    @Override
    public int read(byte[] buffer, int offset, int length) {
        //this is a workaround to handle PA.
        //this is to make sure PA close/stop stream when it is not running.
        //if we call PA read, PA may keep running.
        if (!isRunning()) return 0;
        //System.out.println("YTargetDataLine requested " + length);
        return YNative.read(buffer, offset, length);
    }
}