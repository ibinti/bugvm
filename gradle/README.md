BugVM Gradle Plugin
====================

# Usage
To use BugVM Gradle, include in your gradle build script:

```groovy
// Pull the plugin from Maven Central
buildscript {
    ext {
        bugVMVersion = "1.1.0"
    }
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath "com.bugvm:bugvm-gradle-plugin:$bugVMVersion"
    }
}
```

Deploy
```
cd ~/bugvm/gradle
./gradlew clean build install
./gradlew uploadArchives
```
