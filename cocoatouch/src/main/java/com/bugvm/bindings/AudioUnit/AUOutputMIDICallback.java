package com.bugvm.bindings.AudioUnit;

public interface AUOutputMIDICallback {
    void onMIDIEvent(int status, int data1, int data2, int offsetSampleFrame);

    void onMIDISysEx(byte[] data);
}
