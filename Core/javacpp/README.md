# How to build JavaCPP usig Gradle

```
./gradlew
```

will build and install into your local maven repo.

```
./gradlew upload
```

will build and upload to Maven Central via Sonatye.
You need to set username and password in `~/.gradle/gradle.properties` like shown below
```
signing.keyId=YOUR_GPG_KEYID
signing.password=YOUR_GPG_PASSWORD
nexusUsername=YOUR_SONATYPE_USERNAME
nexusPassword=YOUR_SONATYPE_PASSWORD
```
And if necessary, modify `group = "org.bytedeco"` in `build.gradle` according to the repo.

# Kotlin Sample on how to use javacpp that was built in above step.
```
cd Kotlin_examples
./gradlew
```
should print out
```
Hello javacpp!
Awesome
Hello javacpp!
Test
```

I am on macOS, there is a NativeLibrary.dylib in `native` folder, if you are on Windows or Linux, replace it with yours.
Gradle compiles `src/main/java/NativeLibrary.java`, and then run `javacpp` to generate jni binding, and then execute the example.
