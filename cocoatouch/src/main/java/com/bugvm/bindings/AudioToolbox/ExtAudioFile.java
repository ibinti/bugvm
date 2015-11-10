/*
 * Copyright (C) 2015 BugVM
 */
package com.bugvm.bindings.AudioToolbox;

import com.bugvm.apple.audiotoolbox.AudioFile;
import com.bugvm.apple.audiotoolbox.AudioFileFlags;
import com.bugvm.apple.audiotoolbox.AudioFileType;
import com.bugvm.apple.audiotoolbox.ExtAudioFileProperty;
import com.bugvm.apple.coreaudio.AudioBufferList;
import com.bugvm.apple.coreaudio.AudioChannelLayout;
import com.bugvm.apple.coreaudio.AudioStreamBasicDescription;
import com.bugvm.apple.corefoundation.CFURL;
import com.bugvm.apple.corefoundation.OSStatus;
import com.bugvm.apple.corefoundation.OSStatusException;
import com.bugvm.apple.foundation.NSURL;
import com.bugvm.rt.bro.Bro;
import com.bugvm.rt.bro.NativeObject;
import com.bugvm.rt.bro.Struct;
import com.bugvm.rt.bro.annotation.Bridge;
import com.bugvm.rt.bro.annotation.Library;
import com.bugvm.rt.bro.ptr.*;

@Library("AudioToolbox")
public class ExtAudioFile extends NativeObject {

    public static class ExtAudioFilePtr extends Ptr<ExtAudioFile, ExtAudioFilePtr> {}
    static { Bro.bind(ExtAudioFile.class); }
    protected ExtAudioFile() {}

    public static ExtAudioFile openURL(NSURL url) throws OSStatusException {

        ExtAudioFilePtr ptr = new ExtAudioFilePtr();
        OSStatus status = openNSURL0(url, ptr);

        OSStatusException.throwIfNecessary(status);

        return ptr.get();
    }
    @Bridge(symbol="ExtAudioFileOpenURL", optional=true)
    protected static native OSStatus openNSURL0(NSURL inURL, ExtAudioFilePtr outExtAudioFile);

    public <T extends Struct<T>> T getProperty(ExtAudioFileProperty id, Class<T> type) throws OSStatusException {

        T data = Struct.allocate(type);
        IntPtr dataSize = new IntPtr(Struct.sizeOf(data));
        OSStatus status = getProperty0(id, dataSize, data.as(VoidPtr.class));

        OSStatusException.throwIfNecessary(status);

        return data;
    }
    @Bridge(symbol="ExtAudioFileGetProperty", optional=true)
    protected native OSStatus getProperty0(ExtAudioFileProperty inPropertyID, IntPtr ioPropertyDataSize, VoidPtr outPropertyData);

    public static ExtAudioFile wrapAudioFile(AudioFile audioFile, boolean forWriting) throws OSStatusException {
        ExtAudioFilePtr ptr = new ExtAudioFilePtr();
        OSStatus status = wrapAudioFile0(audioFile, forWriting, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    public static ExtAudioFile create(NSURL url, AudioFileType fileType, AudioStreamBasicDescription streamDesc, AudioChannelLayout channelLayout, AudioFileFlags flags) throws OSStatusException {
        ExtAudioFilePtr ptr = new ExtAudioFilePtr();
        OSStatus status = create0(url, fileType, streamDesc, channelLayout, flags, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    public void dispose() throws OSStatusException {
        OSStatus status = dispose0();
        OSStatusException.throwIfNecessary(status);
    }
    public int read(int numberFrames, AudioBufferList data) throws OSStatusException {
        IntPtr ptr = new IntPtr(numberFrames);
        OSStatus status = read0(ptr, data);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    public void write(int numberFrames, AudioBufferList data) throws OSStatusException {
        OSStatus status = write0(numberFrames, data);
        OSStatusException.throwIfNecessary(status);
    }
    public void writeAsync(int numberFrames, AudioBufferList data) throws OSStatusException {
        OSStatus status = writeAsync0(numberFrames, data);
        OSStatusException.throwIfNecessary(status);
    }
    public void seek(long frameOffset) throws OSStatusException {
        OSStatus status = seek0(frameOffset);
        OSStatusException.throwIfNecessary(status);
    }
    public long tell() throws OSStatusException {
        LongPtr ptr = new LongPtr();
        OSStatus status = tell0(ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    public int getPropertySize(ExtAudioFileProperty id) throws OSStatusException {
        IntPtr ptr = new IntPtr();
        OSStatus status = getPropertyInfo0(id, ptr, null);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    public boolean isPropertyWritable(ExtAudioFileProperty id) throws OSStatusException {
        BooleanPtr ptr = new BooleanPtr();
        OSStatus status = getPropertyInfo0(id, null, ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }

    public <T extends Struct<T>> void setProperty(ExtAudioFileProperty id, T data) throws OSStatusException {
        OSStatus status = setProperty0(id, data == null ? 0 : Struct.sizeOf(data), data == null ? null : data.as(VoidPtr.class));
        OSStatusException.throwIfNecessary(status);
    }
    public int getPropertyAsInt(ExtAudioFileProperty id) throws OSStatusException {
        IntPtr ptr = getProperty(id, IntPtr.class);
        return ptr.get();
    }
    public long getPropertyAsLong(ExtAudioFileProperty id) throws OSStatusException {
        LongPtr ptr = getProperty(id, LongPtr.class);
        return ptr.get();
    }
    public float getPropertyAsFloat(ExtAudioFileProperty id) throws OSStatusException {
        FloatPtr ptr = getProperty(id, FloatPtr.class);
        return ptr.get();
    }
    public double getPropertyAsDouble(ExtAudioFileProperty id) throws OSStatusException {
        DoublePtr ptr = getProperty(id, DoublePtr.class);
        return ptr.get();
    }
    public void setProperty(ExtAudioFileProperty id, int value) throws OSStatusException {
        setProperty(id, new IntPtr(value));
    }
    public void setProperty(ExtAudioFileProperty id, long value) throws OSStatusException {
        setProperty(id, new LongPtr(value));
    }
    public void setProperty(ExtAudioFileProperty id, float value) throws OSStatusException {
        setProperty(id, new FloatPtr(value));
    }
    public void setProperty(ExtAudioFileProperty id, double value) throws OSStatusException {
        setProperty(id, new DoublePtr(value));
    }


    @Bridge(symbol="ExtAudioFileWrapAudioFileID", optional=true)
    protected static native OSStatus wrapAudioFile0(AudioFile inFileID, boolean inForWriting, ExtAudioFilePtr outExtAudioFile);
    @Bridge(symbol="ExtAudioFileCreateWithURL", optional=true)
    protected static native OSStatus create0(NSURL inURL, AudioFileType inFileType, AudioStreamBasicDescription inStreamDesc, AudioChannelLayout inChannelLayout, AudioFileFlags inFlags, ExtAudioFilePtr outExtAudioFile);
    @Bridge(symbol="ExtAudioFileDispose", optional=true)
    protected native OSStatus dispose0();
    @Bridge(symbol="ExtAudioFileRead", optional=true)
    protected native OSStatus read0(IntPtr ioNumberFrames, AudioBufferList ioData);
    @Bridge(symbol="ExtAudioFileWrite", optional=true)
    protected native OSStatus write0(int inNumberFrames, AudioBufferList ioData);
    @Bridge(symbol="ExtAudioFileWriteAsync", optional=true)
    protected native OSStatus writeAsync0(int inNumberFrames, AudioBufferList ioData);
    @Bridge(symbol="ExtAudioFileSeek", optional=true)
    protected native OSStatus seek0(long inFrameOffset);
    @Bridge(symbol="ExtAudioFileTell", optional=true)
    protected native OSStatus tell0(LongPtr outFrameOffset);
    @Bridge(symbol="ExtAudioFileGetPropertyInfo", optional=true)
    protected native OSStatus getPropertyInfo0(ExtAudioFileProperty inPropertyID, IntPtr outSize, BooleanPtr outWritable);


    @Bridge(symbol="ExtAudioFileSetProperty", optional=true)
    protected native OSStatus setProperty0(ExtAudioFileProperty inPropertyID, int inPropertyDataSize, VoidPtr inPropertyData);
}
