# Java Framework Sample

This sample demonstrates how to package Java classes into an iOS dynamic
framework and call the packaged classes via
[JNI](http://docs.oracle.com/javase/8/docs/technotes/guides/jni/) from a
native Objective-C app.

The first step to run this sample is to build the framework via Gradle.
```
./gradlew -Pbugvm.enableBitcode=true build bugvmInstall
```

This will create the framework in `target/bugvm/MyJavaFramework.framework`.

The native app using this framework can then be launched using the `CounterUI`
Xcode project.

*NOTE*: The Xcode project depends on
[Carthage](https://github.com/Carthage/Carthage). Carthage must be installed
in `/usr/local/bin/carthage` in order for this sample to work.

## Details

The Java `CounterService` class is wrapped by the Objective-C `CounterService`
class in `CounterService.m`.

In order to link against the dynamic Java framework the
`MyJavaFramework.framework` library has been added to the `Link Binary With
Libraries` build phase on the `CounterUI` target.

Also, a `Run Script` phase has been added to the build phases of the
`CounterUI` target. This `Run Script` phase runs `/usr/local/bin/carthage
copy-frameworks` with `$(SRCROOT)/../target/bugvm/MyJavaFramework.framework`
as input file. This is necessary to have the framework copied properly and
unnessary architectures removed from the dynamic library file when launched on
the simulator or on device. This script also takes care of signing the
framework.
