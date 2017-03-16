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

public class YMixer extends Mixer.Info implements Mixer {
    public YMixer(String name, String vendor, String description, String version) {
        super(name, vendor, description, version);
    }
    
    @Override
    public Mixer.Info getMixerInfo() {        
        return this;
    }
    
    @Override
    public Line.Info[] getSourceLineInfo() {
        return null;
    }
    
    @Override
    public Line.Info[] getTargetLineInfo() {
        return null;
    }
    
    @Override
    public Line.Info[] getSourceLineInfo(Line.Info info) {
        return null;
    }
    
    @Override
    public Line.Info[] getTargetLineInfo(Line.Info info) {
        return null;
    }
    
    @Override
    public boolean isLineSupported(Line.Info info) {
        return true;
    }
    
    @Override
    public Line getLine(Line.Info info) throws LineUnavailableException {
        //check info and get the right line and return
        if(info.getLineClass().equals(SourceDataLine.class)) {
            //System.out.println("YMixer returning (Line)new YSourceDataLine(info);");
            return (Line)new YSourceDataLine(info);
        }
        //
        //check info and get the right line and return
        if(info.getLineClass().equals(TargetDataLine.class)) {
            //System.out.println("YMixer returning (Line)new YTargetDataLine(info);");
            return (Line)new YTargetDataLine(info);
        }
        //
        //check info and get the right line and return
        if(info.getLineClass().equals(Clip.class)) {
            //System.out.println("YMixer returning (Line)new YClip(info);");
            return (Line)new YClip(info);
        }
        //
        return (Line)new YLine(info);
    }
    
    public Line getLine(Port.Info info) throws LineUnavailableException {
        //check info and get the right line and return
        if(info.getLineClass().equals(Port.class)) {
            return (Line)new YPort(info);
        }
        //
        return (Line)new YLine(info);
    }
    
    @Override
    public int getMaxLines(Line.Info info) {
        return 0;
    }
    
    @Override
    public Line[] getSourceLines() {
        Line[] line = new Line[1];
        line[0] = (Line)new YSourceDataLine();
        return line;
    }
    
    @Override
    public Line[] getTargetLines() {
        Line[] line = new Line[1];
        line[0] = (Line)new YTargetDataLine();
        return line;
    }
    
    @Override
    public void synchronize(Line[] aLines, boolean bMaintainSync) {
    //
    }
    
    @Override
    public void unsynchronize(Line[] aLines) {
    //
    }
    
    @Override
    public boolean isSynchronizationSupported(Line[] aLines, boolean bMaintainSync) {
         return false;
    }
    
    @Override
    public Line.Info getLineInfo() {
         return null;
    }
    
    @Override
    public void open() throws LineUnavailableException {
    //
    }
    
    @Override
    public void close() {
    //
    }
    
    @Override
    public boolean isOpen() {
        return true;
    }
    
    @Override
    public Control[] getControls() {
        return null;
    }
    
    @Override
    public boolean isControlSupported(Control.Type controlType) {
        return true;
    }
    
    @Override
    public Control getControl(Control.Type controlType) {
        return null;
    }
    
    @Override
    public void addLineListener(LineListener listener) {
    //
    }
    
    @Override
    public void removeLineListener(LineListener listener) {
    //
    }   
}