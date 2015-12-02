# BugVM

BugVM is a fork of RoboVM.

# Build from source

### Prerequisites

In order to get the source code and build BugVM you will need the following tools:

* [Git](http://git-scm.com)
* [CMake](http://www.cmake.org) 2.8.8 or newer
* Java JDK 8
* [Maven 3.x](http://maven.apache.org)
* Xcode 7

**Mac OS X 10.11**

Download and install Java SE JDK 8 from Oracle. Make sure `$JAVA_HOME` is set properly by adding
```bash
$ export JAVA_HOME=$(/usr/libexec/java_home)
```
to ~/.profile.

Install Xcode7 from the Mac App Store.

Use Xcode 7 if there are multiple versions of Xcode
```
sudo xcode-select -s /Applications/Xcode7/Xcode.app
```

Download and install CMake.

Get Maven from the URL above and install it.

You may need to install pkg-config if this is first time.
```
brew install pkg-config
```

Install any other missing components your build systems complain about.

# Clone BugVM

Clone bugvm github repo to ~/bugvm/bugvm.

# Build the vm core libraries

The code of the vm core libraries is in the `vm/` folder in the repository. To start a build run 
```bash
cd ~/bugvm/bugvm/vm
./build.sh --clean --build=release
```
will install to ~/bugvm/bugvm/vm/target/binaries. 
There are few command line options to control the build type and targets to build for. For help run:
```bash
$ ./build.sh --help
```

#Build libbugvm-llvm.dylib
```
cd ~/bugvm/bugvm/llvm
./build.sh --clean
```
will install to ~/bugvm/bugvm/llvm/src/main/resources/com/bugvm/llvm/binding/macosx/x86_64/libbugvm-llvm.dylib

#Build libbugvm-libimobiledevice.dylib
```
cd ~/bugvm/bugvm/libimobiledevice
./build.sh --clean
```
will install libbugvm-libimobiledevice.dylib to /src/main/resources/com/bugvm/libimobiledevice/binding/macosx/x86_64

#Build ios-sim
```
cd ~/bugvm/bugvm/ios-sim
./build.sh
```
will build ios-sim and install it to ~/bugvm/bugvm/bin

# Build the other components

The rest of BugVM is built using Maven.
```bash
cd ~/bugvm/bugvm
mvn clean install
```

If you see errors such as:
```
com.bugvm.libimobiledevice.AfcClientTest  Time elapsed: 0 sec  <<< ERROR!
com.bugvm.libimobiledevice.LibIMobileDeviceException: LOCKDOWN_E_PASSWORD_PROTECTED
	at com.bugvm.libimobiledevice.LockdowndClient.checkResult(LockdowndClient.java:148)
	at com.bugvm.libimobiledevice.LockdowndClient.<init>(LockdowndClient.java:58)
	at com.bugvm.libimobiledevice.AfcClientTest.beforeClass(AfcClientTest.java:57)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:57)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:606)
```
make sure you do not have an iOS device connected that has **not** been provisioned for development.

## The BUGVM_DEV_ROOT environment variable

When developing BugVM it is convenient to be able to run the compiler and link against the vm core libraries and runtime classes without creating a distribution package first. The `bin/bugvm` script and the compiler code look for the `$BUGVM_DEV_ROOT` environment variable when determining how to launch the compiler and what to link against. 

If `$BUGVM_DEV_ROOT` is set `bin/bugvm` will use the compiler matching `$BUGVM_DEV_ROOT/compiler/target/bugvm-compiler-*.jar` and the compiler will link against the vm core libraries in `vm/target/binaries/` and use the runtime classes in `$BUGVM_DEV_ROOT/rt/target/bugvm-rt-<version>.jar`.

## Debugging the vm core libraries

If you're hacking on the vm code it is often necessary to debug that code. First you have to build debug versions of the vm core libraries as described above. You can then build and debug an executable linked against the debug version of the libraries using:
```bash
$ export BUGVM_DEV_ROOT=/path/to/checked/out/repository 
$ $BUGVM_DEV_ROOT/bugvm -cp ... -verbose -use-debug-libs -d /tmp/foo org.my.main.Class
$ gdb /tmp/foo/org.my.main.Class
```

## Controlling a BugVM executable

An executable produced with BugVM can be controlled from the command line using a few special command line options. All options start with `-rvm:`. These options have to be specified before any non `-rvm:` option on the command line and will not be visible to the Java program.

* `-rvm:log=silent|fatal|error|warn|info|debug|trace`  
  Enables log messages from the vm core code. If not specified the default logging level is `error`.
* `-rvm:mx<size>[k|K|m|M|g|G]`  
  Sets the max heap size in bytes, kB, MB or GB. E.g. `-rvm:mx=128M` sets the max heap size to 128 MB.
* `-rvm:ms<size>[k|K|m|M|g|G]`  
  Sets the initial heap size. The value is interpreted the same as the `-rvm:mx` values.
* `-rvm:MainClass`  
  Sets the main class to be launched if no main class was specified when the executable was compiled.
