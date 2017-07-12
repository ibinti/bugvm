# BugVM Plugin for the Gradle

It allows to use BugVM with gradle build system.

```
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("com.bugvm:bugvm-gradle:1.2.3")
    }
}

apply plugin: "bugvm"
```
