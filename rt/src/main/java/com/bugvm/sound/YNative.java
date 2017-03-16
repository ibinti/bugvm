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

public class YNative {
    
    public static int Initialize() {
       return 0;//SoundLib.LIB.Initialize();
    }
    
    public static int Terminate() {
        return 0;//SoundLib.LIB.Terminate();
    }
    
    public static int GetDeviceCount() {
        return 0;//SoundLib.LIB.GetDeviceCount();
    }
    
    public static int GetDefaultInputDevice() {
        return 0;//SoundLib.LIB.GetDefaultInputDevice();
    }
    
    public static int GetDefaultOutputDevice() {
        return 0;//SoundLib.LIB.GetDefaultOutputDevice();
    }
    
    public static String GetDeviceInfo(int device) {
        return "";//SoundLib.LIB.GetDeviceInfo(device);
    }
    
    public static void InputLineOpen(int Device, int Encoding,int FrameRate,int BitsPerSample,int Channels,int FrameSize,int SampleRate,boolean isBigEndian,int BufferSize) {
        //SoundLib.LIB.InputLineOpen(Device, Encoding, FrameRate, BitsPerSample, Channels, FrameSize, SampleRate, isBigEndian, BufferSize);
    }
    
    public static void OutputLineOpen(int Device, int Encoding,int FrameRate,int BitsPerSample,int Channels,int FrameSize,int SampleRate,boolean isBigEndian,int BufferSize) {
        //SoundLib.LIB.OutputLineOpen(Device, Encoding, FrameRate, BitsPerSample, Channels, FrameSize, SampleRate, isBigEndian, BufferSize);
    }
    
    public static void close() {
        //SoundLib.LIB.Close();
    }
    
    public static int read(byte[] buffer, int offset, int length) {
        return 0;//SoundLib.LIB.Read(buffer, offset, length);
    }
    
    ///
    ///blocking call
    public static int write(byte[] buffer, int offset, int length) {
        return 0;//SoundLib.LIB.Write(buffer, offset, length);
    }
    
    public static void start() {
        //SoundLib.LIB.Start();
    }
    
    public static void stop() {
        //SoundLib.LIB.Stop();
    }
}