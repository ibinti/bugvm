package com.badlogic.gdx.backends.iobugvm.objectal;

import com.bugvm.apple.foundation.NSArray;
import com.bugvm.apple.foundation.NSObject;
import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.objc.annotation.Property;
import com.bugvm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass
public class ALSoundSourcePool extends NSObject {

	static {
		ObjCRuntime.bind(ALSoundSourcePool.class);
	}
	
	@Property(selector = "sources")
	public native NSArray<ALSource> getSources ();
	
}