package com.bugvm.samples.customframeworks;

import com.bugvm.apple.foundation.NSObject;
import com.bugvm.objc.annotation.Method;
import com.bugvm.objc.annotation.NativeClass;
import com.bugvm.rt.bro.annotation.Library;

@NativeClass("MySwiftFramework.SwiftAdder")
@Library(Library.INTERNAL)
public class SwiftAdder extends NSObject {
	@Method(selector="add:b:")
	public native int add(int a, int b);
}
