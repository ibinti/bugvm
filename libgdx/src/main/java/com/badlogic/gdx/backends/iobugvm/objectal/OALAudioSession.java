
package com.badlogic.gdx.backends.iobugvm.objectal;

import com.bugvm.apple.foundation.NSObject;
import com.bugvm.objc.ObjCRuntime;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.rt.bro.annotation.Library;

@Library(Library.INTERNAL)
@NativeClass
public final class OALAudioSession extends NSObject {
	static {
		ObjCRuntime.bind(OALAudioSession.class);
	}

	@Method
	public native static OALAudioSession sharedInstance ();

	@Method
	public native void forceEndInterruption ();
}
