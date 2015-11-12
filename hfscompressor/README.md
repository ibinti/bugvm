### Building
Make sure `/System/Library/Frameworks/JavaVM.framework/Headers` exists, which contains the 
JNI headers. If the directory does not exist, symlink it to `/Library/Java/JavaVirtualMachines/jdk1.8.0_60.jdk/Contents/Home/include` (adjust for your JDK installation directory).

```bash
./build.sh
```

This will download and build libarchive-3.1.2 and build `libhfscompressor.dylib`, and copy `libhfscompressor.dylib` to `bugvm/bin`
