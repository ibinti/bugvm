package com.badlogic.gdx.backends.iosbugvm.objectal;

import com.bugvm.apple.foundation.NSObject;
import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;
import com.bugvm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass
public final class ALChannelSource extends NSObject {

	static {
		ObjCRuntime.bind(ALChannelSource.class);
	}
	
	@Property(selector = "sourcePool")
	public native ALSoundSourcePool getSourcePool ();
	
}