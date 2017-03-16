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
import java.util.*;

public class YLine implements Line {
    Line.Info info;
    //
    boolean isOpen = false;
    //
    java.util.concurrent.ConcurrentHashMap linelisteners = new java.util.concurrent.ConcurrentHashMap();
    //
    public YLine() {
      //
    }
    //
    public YLine(Line.Info info) {
        this.info = info;
        if(Boolean.getBoolean("YDEBUG"))
        {
            System.out.println("returning from YLine(Line.Info info)");
        }
    }
    //
    @Override
    public Line.Info getLineInfo() {
        return this.info;
    }
    
    @Override
    public void open() throws LineUnavailableException {
        //System.out.println("YLine open()");
        isOpen = true;
        //
        YNative.Initialize();
        
        if(Boolean.getBoolean("YDEBUG")) {
            int devices = YNative.GetDeviceCount();
            System.out.println("GetDeviceCount " + devices);
            for(int i=0;i<devices;i++) {
                System.out.println("name: " + YNative.GetDeviceInfo(i));
            }
        }
        //
        //call LineListeners and let them know
        NotifiyListeners(LineEvent.Type.OPEN, 0);
    }
    
    @Override
    public void close() {
        if(Boolean.getBoolean("YDEBUG")) {
             System.out.println("YLine.close()");
        }
        //
        YNative.close();
        YNative.Terminate();
        //
        isOpen = false;
        //
        //call LineListeners and let them know
        NotifiyListeners(LineEvent.Type.CLOSE,0);
    }
    
    @Override
    public boolean isOpen() {
        return isOpen;
    }
    
    @Override
    public Control[] getControls() {
        return null;
    }
    
    @Override
    public boolean isControlSupported(Control.Type controlType) {
        return false;
    }
    
    @Override
    public Control getControl(Control.Type controlType) {
        return null;
    }
    
    @Override
    public void addLineListener(LineListener listener) {
        //add it to hastable
        //
        //i think it does not matter if i check for key or value
        if(linelisteners.containsKey(listener)) return; 
        //if(linelisteners.containsValue(listener)) return;
        //
        //as i put both key and value the listner
        linelisteners.put(listener, listener);
    }
    
    @Override
    public void removeLineListener(LineListener listener) {
        //remove it from hashtable
        //
        if(linelisteners.containsKey(listener)) 
        {
            linelisteners.remove(listener);
        } 
    }
    
    public void NotifiyListeners(LineEvent.Type type, long position) {
        if(!linelisteners.isEmpty()) {
            for (Enumeration e = linelisteners.elements() ; e.hasMoreElements() ;) {
                LineListener listener = (LineListener)e.nextElement();
                LineEvent event = new LineEvent(this, type, position);
                listener.update(event);
            }            
        }
    }
}