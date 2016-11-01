BugVM Gradle Plugin
====================

# Usage
To use BugVM Gradle, include in your gradle build script:

```
buildscript {
    ext {
        bugVMVersion = "1.1.0"
    }
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath "com.bugvm:bugvm-gradle:$bugVMVersion"
    }
}
```

Deploy
```
cd ~/bugvm/bugvm-gradle
gradle clean build install
gradle uploadArchives
```
