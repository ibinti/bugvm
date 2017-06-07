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

import java.io.IOException;
import javax.sound.sampled.*;

public class YClip extends YDataLine implements Clip, Runnable {
    //static final int LOOP_CONTINUOUSLY = -1;
    byte[] data = null;
    int BufferSize = 1024;
    int LoopCount  = 0;
    int LoopCounter=0;
    Thread thread = null;
    //
    public YClip(Line.Info info) {
        super(info);
        if(Boolean.getBoolean("YDEBUG")) {
            System.out.println("returning from YClip(Line.Info info)");
        }
    }
    
    @Override
    public int getFrameLength() {
    //Obtains the media length in sample frames.
        return 0;
    }
    
    @Override
    public long getMicrosecondLength() {
     //Obtains the media duration in microseconds
        return 0;
    }
    
    @Override
    public void loop(int count) {
    // Starts looping playback from the current position.
        LoopCount = count;
    }
    
    @Override
    public void open(AudioFormat audioFormat, byte[] buffer, int offset, int bufferSize) throws LineUnavailableException { 
        super.open();
        this.audioFormat = audioFormat;
        this.data = new byte[bufferSize];
        //
        System.arraycopy(buffer, offset, this.data, 0, bufferSize);
        //
        int Encoding = 0;// convert this to int, audioFormat.getEncoding();
        int FrameRate = (int)audioFormat.getFrameRate();
        int BitsPerSample = audioFormat.getSampleSizeInBits();
        int Channels = audioFormat.getChannels();
        int FrameSize= audioFormat.getFrameSize();
        int SampleRate = (int)audioFormat.getSampleRate();
        boolean isBigEndian = audioFormat.isBigEndian();
        BufferSize = 1024;
        int device = YNative.GetDefaultOutputDevice();
        YNative.OutputLineOpen(device,Encoding,FrameRate,BitsPerSample,Channels,FrameSize,SampleRate,isBigEndian,BufferSize);
    }
    
    @Override
    public void open(AudioInputStream stream) throws LineUnavailableException {
        int size = 5000000;
        //int size = (int)(stream.getFrameLength() * stream.getFormat().getFrameSize());
        //
        byte[] buffer = new byte[size];
        //
        int offset = 0;
        int bufferSize = buffer.length;
        //
        try {
            stream.read(buffer, offset, bufferSize);
        }  catch (IOException ex) {
            if(Boolean.getBoolean("YDEBUG")) {
            }
        }
        //
        open(stream.getFormat(),buffer,offset,bufferSize);
    }
    
    @Override
    public void start() {
        super.start();
        thread = new Thread(this);
        thread.setDaemon(true);
        thread.start();
    }
    
    @Override
    public void stop() {
        if(thread!=null) {
            thread.interrupt();
            thread = null;
        }
        //
        super.stop();
    }
    //
    int bufferLength = BufferSize;//getBufferSize();
    int ReadPos = 0;
    //
    @Override
    public void run() {
        while(thread!=null) {
            //get data
            byte[] buffer = new byte[bufferLength];
            read(buffer);
            //
            //write it
            YNative.write(buffer,0,buffer.length);
        }
    }
    
    public void read(byte[] buffer) {
        int offset = 0;
        int length = buffer.length;
        //
        if(ReadPos + length <= data.length ) {
           System.arraycopy(data,ReadPos,buffer,0,length);               
           ReadPos += length;
        } else {  
           //1. read up to data.length
           int soundBufferRemain = data.length - ReadPos;
           System.arraycopy(data,ReadPos,buffer,offset,soundBufferRemain);   
           offset += soundBufferRemain;
           length -= offset;
           //calculate how many wrap-arounds to go more
           int toGo = length / data.length;
           int remain = length % data.length;
           //
           if(toGo>0) {//we have wrap-arounds, do it here
               for(int r=0;r<toGo;r++) {
                   System.arraycopy(data,0,buffer,offset,data.length);
                   offset += data.length;
                   ReadPos = 0;
               }               
           }
           //
           if(remain>0) {
               System.arraycopy(data,0, buffer, offset, remain);
               offset += remain;
               ReadPos = remain;
           }
        }
    }
    
    @Override
    public void setFramePosition(int frames) {
     //Sets the media position in sample frames.
    }
    
    @Override
    public void setLoopPoints(int start, int end) {
     //Sets the first and last sample frames that will be played in the loop.
    }
    
    @Override
    public void setMicrosecondPosition(long microseconds) {
     //Sets the media position in microseconds.
    }
}