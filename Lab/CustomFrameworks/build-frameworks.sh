function buildFramework {
	FRAMEWORK=$1
	xcodebuild -project $FRAMEWORK/$FRAMEWORK.xcodeproj/ clean

	xcodebuild -project $FRAMEWORK/$FRAMEWORK.xcodeproj/ -configuration Release -arch i386 -sdk iphonesimulator build
	cp $FRAMEWORK/build/Release-iphonesimulator/$FRAMEWORK.framework/$FRAMEWORK $FRAMEWORK/build/$FRAMEWORK.i386.dylib

	xcodebuild -project $FRAMEWORK/$FRAMEWORK.xcodeproj/ -configuration Release -arch x86_64 -sdk iphonesimulator build
	cp $FRAMEWORK/build/Release-iphonesimulator/$FRAMEWORK.framework/$FRAMEWORK $FRAMEWORK/build/$FRAMEWORK.x86_64.dylib

	xcodebuild -project $FRAMEWORK/$FRAMEWORK.xcodeproj/ -configuration Release -arch armv7 -sdk iphoneos build
	cp $FRAMEWORK/build/Release-iphoneos/$FRAMEWORK.framework/$FRAMEWORK $FRAMEWORK/build/$FRAMEWORK.armv7.dylib

	xcodebuild -project $FRAMEWORK/$FRAMEWORK.xcodeproj/ -configuration Release -arch arm64 -sdk iphoneos build
	cp $FRAMEWORK/build/Release-iphoneos/$FRAMEWORK.framework/$FRAMEWORK $FRAMEWORK/build/$FRAMEWORK.arm64.dylib

	lipo $FRAMEWORK/build/$FRAMEWORK.i386.dylib $FRAMEWORK/build/$FRAMEWORK.x86_64.dylib $FRAMEWORK/build/$FRAMEWORK.armv7.dylib $FRAMEWORK/build/$FRAMEWORK.arm64.dylib -create -output $FRAMEWORK/build/$FRAMEWORK

	cp -r $FRAMEWORK/build/Release-iphoneos/$FRAMEWORK.framework/ $FRAMEWORK/build/$FRAMEWORK.framework
	cp $FRAMEWORK/build/$FRAMEWORK $FRAMEWORK/build/$FRAMEWORK.framework/
}

buildFramework "MyObjectiveCFramework"
buildFramework "MySwiftFramework"