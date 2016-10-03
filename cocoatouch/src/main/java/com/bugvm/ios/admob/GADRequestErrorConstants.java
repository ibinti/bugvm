
package com.bugvm.ios.admob;

import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;

@NativeClass("GADRequestErrorWrapped")
class GADRequestErrorConstants {
	private GADRequestErrorConstants () {
	}

	@Method(selector = "kGADErrorDomain")
	static native String errorDomain ();
}
