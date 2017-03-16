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

public interface SoundLib {
    //SoundLib LIB = (SoundLib) com.sun.jna.Native.loadLibrary("BugVMSound", SoundLib.class);
       
    void SetLOWPASS(int lowpass);
    void VR(byte[] in, int size, byte[] out);
    void GetPeaks(byte[] in, int size, int[] peaks);
    
    //InputOutput API
    int Initialize();
    int Terminate();
    //
    int GetDeviceCount();
    int GetDefaultInputDevice();
    int GetDefaultOutputDevice();
    String GetDeviceInfo(int device);
    //
    void InputLineOpen(int Device, int Encoding,int FrameRate,int BitsPerSample,int Channels,int FrameSize,int SampleRate,boolean isBigEndian,int BufferSize);
    void OutputLineOpen(int Device, int Encoding,int FrameRate,int BitsPerSample,int Channels,int FrameSize,int SampleRate,boolean isBigEndian,int BufferSize);
    void Close();
    //
    int Read(byte[] buffer, int offset, int length);
    int Write(byte[] buffer, int offset, int length);//blocking call
    //
    void Start();
    void Stop();
       
    //WMA
    void WMAInitialize();
    void WMATerminate();
    void WMAReaderCreate();
    void WMAReaderDelete();
    int WMAReaderOpen(String filename,int[] MaxBufferSize);
    int WMAReaderFileSize();
    int WMAReaderGetFileDuration();
    void WMASeekPosition(long pos);
    int WMARead(byte[] buffer, int offset, int size);
    int WMAReaderClose();
    int WMAReaderGetBitrate();
    void WMAReaderGetWfx(WAVEFORMATEX wfx);
    
    void Initialize_WMA();
    void Terminate_WMA();
    int FileReadOpenWMAMP3File(String filename, WAVEFORMATEX wfx,  int[] BufferSize);
    int FileRead(byte[] buffer, int offset, int size);
    long FileReadGetFileDuration();
    void FileReadCloseFile();
    int FileGetBitRate();
    void SeekPosition(long cnsPos);
    
    //OS X
    void FileOpenApple(String filename, WAVEFORMATEX wfx);
    int FileReadApple(byte[] buffer, int size);
    void FileCloseApple();
    long FileDurationApple();//in cns
    
    void InitCodec();
    void CleanupCodec();
    void Encode(byte[] inData, int inSize, byte[] outData, int[] outSize);
    void WriteCodec(byte[] inData, int inSize);
    void ReadCodec(byte[] outData, int[] outSize);
    void Volume(byte[] outData, int outSize, int volume);
}