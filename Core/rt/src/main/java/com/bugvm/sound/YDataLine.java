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

public class YDataLine extends YLine implements DataLine {
    private boolean isRunning = false;
    //
    protected AudioFormat audioFormat = null;
    private int BufferSize = 0;
    //
    public YDataLine(Line.Info info) {
        super(info);
        if(Boolean.getBoolean("YDEBUG")) {
            System.out.println("YDataLine(Line.Info info)");
        }
    }
    
    public YDataLine() {
        if(Boolean.getBoolean("YDEBUG")) {
            System.out.println("YDataLine()");
        }
    }
    
    public void open(AudioFormat audioFormat, int BufferSize) throws LineUnavailableException {
        this.audioFormat = audioFormat;
        this.BufferSize = BufferSize;
        super.open();
    }
    
    @Override
    public void drain() {
        if(Boolean.getBoolean("YDEBUG"))
        {
            System.out.println("YDataLine.drain()");
        }
        //
    }
    
    @Override
    public void flush() {
        if(Boolean.getBoolean("YDEBUG")) {
            System.out.println("YDataLine.flush()");
        }
    }
    
    @Override
    public void start() {
        YNative.start();
        isRunning = true;
        //call LineListeners and let them know
        NotifiyListeners(LineEvent.Type.START,0);
        if(Boolean.getBoolean("YDEBUG")) {
            System.out.println("YDataLine.start()");
        }
    }
    
    @Override
    public void stop() {
        YNative.stop();
        isRunning = false;
        //call LineListeners and let them know
        NotifiyListeners(LineEvent.Type.STOP,0);
        if(Boolean.getBoolean("YDEBUG")) {
            System.out.println("YDataLine.stop()");
        }
    }
    
    @Override
    public boolean isRunning() {
        return isRunning;
    }
    
    @Override
    public boolean isActive() {
        return isRunning;
    }
    
    @Override
    public AudioFormat getFormat() {
         return audioFormat;
    }
    
    @Override
    public int getBufferSize() {
        return this.BufferSize;
    }
    
    @Override
    public int available() {
        return -1;
    }
    
    @Override
    public int getFramePosition() {
        return -1;
    }
    
    @Override
    public long getLongFramePosition() {
        return -1;
    }
    
    @Override
    public long getMicrosecondPosition() {
        return -1;
    }
    
    @Override
    public float getLevel() {
        return 0;
    }
}