/*
 * Copyright (C) 2013-2015 RoboVM AB
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
package com.bugvm.ios.AudioToolbox;

/*<imports>*/

import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.coremidi.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("AudioToolbox")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MusicTrack/*</name>*/ 
    extends /*<extends>*/NativeObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class MusicTrackPtr extends Ptr<MusicTrack, MusicTrackPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(MusicTrack.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected MusicTrack() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public com.bugvm.ios.AudioToolbox.MusicSequence getSequence() throws OSStatusException {
        com.bugvm.ios.AudioToolbox.MusicSequence.MusicSequencePtr ptr = new com.bugvm.ios.AudioToolbox.MusicSequence.MusicSequencePtr();
        OSStatus status = getSequence0(ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void setDestNode(int node) throws OSStatusException {
        OSStatus status = setDestNode0(node);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    public void setDestMIDIEndpoint(MIDIEndpoint endpoint) throws OSStatusException {
        OSStatus status = setDestMIDIEndpoint0(endpoint);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public int getDestNode() throws OSStatusException {
        IntPtr ptr = new IntPtr();
        OSStatus status = getDestNode0(ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    public MIDIEndpoint getDestMIDIEndpoint() throws OSStatusException {
        MIDIEndpoint.MIDIEndpointPtr ptr = new MIDIEndpoint.MIDIEndpointPtr();
        OSStatus status = getDestMIDIEndpoint0(ptr);
        OSStatusException.throwIfNecessary(status);
        return ptr.get();
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public <T extends Struct<T>> T getProperty(com.bugvm.ios.AudioToolbox.MusicTrackProperty id, Class<T> type) throws OSStatusException {
        T data = Struct.allocate(type);
        IntPtr dataSize = new IntPtr(Struct.sizeOf(data));
        OSStatus status = getProperty0(id, data.as(VoidPtr.class), dataSize);
        OSStatusException.throwIfNecessary(status);
        return data;
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public <T extends Struct<T>> void setProperty(com.bugvm.ios.AudioToolbox.MusicTrackProperty id, T data) throws OSStatusException {
        OSStatus status = setProperty0(id, data == null ? null : data.as(VoidPtr.class), data == null ? 0 : Struct.sizeOf(data));
        OSStatusException.throwIfNecessary(status);
    }
    public int getPropertyAsInt(com.bugvm.ios.AudioToolbox.MusicTrackProperty id) throws OSStatusException {
        IntPtr ptr = getProperty(id, IntPtr.class);
        return ptr.get();
    }
    public long getPropertyAsLong(com.bugvm.ios.AudioToolbox.MusicTrackProperty id) throws OSStatusException {
        LongPtr ptr = getProperty(id, LongPtr.class);
        return ptr.get();
    }
    public float getPropertyAsFloat(com.bugvm.ios.AudioToolbox.MusicTrackProperty id) throws OSStatusException {
        FloatPtr ptr = getProperty(id, FloatPtr.class);
        return ptr.get();
    }
    public double getPropertyAsDouble(com.bugvm.ios.AudioToolbox.MusicTrackProperty id) throws OSStatusException {
        DoublePtr ptr = getProperty(id, DoublePtr.class);
        return ptr.get();
    }
    public void setProperty(com.bugvm.ios.AudioToolbox.MusicTrackProperty id, int value) throws OSStatusException {
        setProperty(id, new IntPtr(value));
    }
    public void setProperty(com.bugvm.ios.AudioToolbox.MusicTrackProperty id, long value) throws OSStatusException {
        setProperty(id, new LongPtr(value));
    }
    public void setProperty(com.bugvm.ios.AudioToolbox.MusicTrackProperty id, float value) throws OSStatusException {
        setProperty(id, new FloatPtr(value));
    }
    public void setProperty(com.bugvm.ios.AudioToolbox.MusicTrackProperty id, double value) throws OSStatusException {
        setProperty(id, new DoublePtr(value));
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void moveEvents(double startTime, double endTime, double moveTime) throws OSStatusException {
        OSStatus status = moveEvents0(startTime, endTime, moveTime);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void clear(double startTime, double endTime) throws OSStatusException {
        OSStatus status = clear0(startTime, endTime);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void cut(double startTime, double endTime) throws OSStatusException {
        OSStatus status = cut0(startTime, endTime);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void copyInsert(double sourceStartTime, double sourceEndTime, MusicTrack destTrack, double destInsertTime) throws OSStatusException {
        OSStatus status = copyInsert0(sourceStartTime, sourceEndTime, destTrack, destInsertTime);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void merge(double sourceStartTime, double sourceEndTime, MusicTrack destTrack, double destInsertTime) throws OSStatusException {
        OSStatus status = merge0(sourceStartTime, sourceEndTime, destTrack, destInsertTime);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void newMIDINoteEvent(double timeStamp, com.bugvm.ios.AudioToolbox.MIDINoteMessage message) throws OSStatusException {
        OSStatus status = newMIDINoteEvent0(timeStamp, message);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void newMIDIChannelEvent(double timeStamp, com.bugvm.ios.AudioToolbox.MIDIChannelMessage message) throws OSStatusException {
        OSStatus status = newMIDIChannelEvent0(timeStamp, message);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void newMIDIRawDataEvent(double timeStamp, com.bugvm.ios.AudioToolbox.MIDIRawData rawData) throws OSStatusException {
        OSStatus status = newMIDIRawDataEvent0(timeStamp, rawData);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void newExtendedNoteEvent(double timeStamp, com.bugvm.ios.AudioToolbox.ExtendedNoteOnEvent info) throws OSStatusException {
        OSStatus status = newExtendedNoteEvent0(timeStamp, info);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void newParameterEvent(double timeStamp, com.bugvm.ios.AudioToolbox.AUParameterEvent info) throws OSStatusException {
        OSStatus status = newParameterEvent0(timeStamp, info);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void newExtendedTempoEvent(double timeStamp, double bpm) throws OSStatusException {
        OSStatus status = newExtendedTempoEvent0(timeStamp, bpm);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void newMetaEvent(double timeStamp, com.bugvm.ios.AudioToolbox.MIDIMetaEvent metaEvent) throws OSStatusException {
        OSStatus status = newMetaEvent0(timeStamp, metaEvent);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void newUserEvent(double timeStamp, com.bugvm.ios.AudioToolbox.MusicEventUserData userData) throws OSStatusException {
        OSStatus status = newUserEvent0(timeStamp, userData);
        OSStatusException.throwIfNecessary(status);
    }
    /**
     * @throws OSStatusException 
     * @since Available in iOS 5.0 and later.
     */
    public void newAUPresetEvent(double timeStamp, com.bugvm.ios.AudioToolbox.AUPresetEvent presetEvent) throws OSStatusException {
        OSStatus status = newAUPresetEvent0(timeStamp, presetEvent);
        OSStatusException.throwIfNecessary(status);
    }
    /*<methods>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackGetSequence", optional=true)
    protected native OSStatus getSequence0(com.bugvm.ios.AudioToolbox.MusicSequence.MusicSequencePtr outSequence);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackSetDestNode", optional=true)
    protected native OSStatus setDestNode0(int inNode);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    @Bridge(symbol="MusicTrackSetDestMIDIEndpoint", optional=true)
    protected native OSStatus setDestMIDIEndpoint0(MIDIEndpoint inEndpoint);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackGetDestNode", optional=true)
    protected native OSStatus getDestNode0(IntPtr outNode);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    @Bridge(symbol="MusicTrackGetDestMIDIEndpoint", optional=true)
    protected native OSStatus getDestMIDIEndpoint0(MIDIEndpoint.MIDIEndpointPtr outEndpoint);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackSetProperty", optional=true)
    protected native OSStatus setProperty0(com.bugvm.ios.AudioToolbox.MusicTrackProperty inPropertyID, VoidPtr inData, int inLength);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackGetProperty", optional=true)
    protected native OSStatus getProperty0(com.bugvm.ios.AudioToolbox.MusicTrackProperty inPropertyID, VoidPtr outData, IntPtr ioLength);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackMoveEvents", optional=true)
    protected native OSStatus moveEvents0(double inStartTime, double inEndTime, double inMoveTime);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackClear", optional=true)
    protected native OSStatus clear0(double inStartTime, double inEndTime);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackCut", optional=true)
    protected native OSStatus cut0(double inStartTime, double inEndTime);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackCopyInsert", optional=true)
    protected native OSStatus copyInsert0(double inSourceStartTime, double inSourceEndTime, MusicTrack inDestTrack, double inDestInsertTime);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackMerge", optional=true)
    protected native OSStatus merge0(double inSourceStartTime, double inSourceEndTime, MusicTrack inDestTrack, double inDestInsertTime);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackNewMIDINoteEvent", optional=true)
    protected native OSStatus newMIDINoteEvent0(double inTimeStamp, com.bugvm.ios.AudioToolbox.MIDINoteMessage inMessage);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackNewMIDIChannelEvent", optional=true)
    protected native OSStatus newMIDIChannelEvent0(double inTimeStamp, com.bugvm.ios.AudioToolbox.MIDIChannelMessage inMessage);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackNewMIDIRawDataEvent", optional=true)
    protected native OSStatus newMIDIRawDataEvent0(double inTimeStamp, com.bugvm.ios.AudioToolbox.MIDIRawData inRawData);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackNewExtendedNoteEvent", optional=true)
    protected native OSStatus newExtendedNoteEvent0(double inTimeStamp, com.bugvm.ios.AudioToolbox.ExtendedNoteOnEvent inInfo);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackNewParameterEvent", optional=true)
    protected native OSStatus newParameterEvent0(double inTimeStamp, com.bugvm.ios.AudioToolbox.AUParameterEvent inInfo);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackNewExtendedTempoEvent", optional=true)
    protected native OSStatus newExtendedTempoEvent0(double inTimeStamp, double inBPM);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackNewMetaEvent", optional=true)
    protected native OSStatus newMetaEvent0(double inTimeStamp, com.bugvm.ios.AudioToolbox.MIDIMetaEvent inMetaEvent);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackNewUserEvent", optional=true)
    protected native OSStatus newUserEvent0(double inTimeStamp, com.bugvm.ios.AudioToolbox.MusicEventUserData inUserData);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="MusicTrackNewAUPresetEvent", optional=true)
    protected native OSStatus newAUPresetEvent0(double inTimeStamp, com.bugvm.ios.AudioToolbox.AUPresetEvent inPresetEvent);
    /*</methods>*/
}
