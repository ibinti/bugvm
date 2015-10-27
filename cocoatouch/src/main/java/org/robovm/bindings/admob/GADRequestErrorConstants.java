
package org.robovm.bindings.admob;

import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass("GADRequestErrorWrapped")
class GADRequestErrorConstants {
	private GADRequestErrorConstants () {
	}

	@Method(selector = "kGADErrorDomain")
	static native String errorDomain ();
}
