BugVM Gradle Plugin v1.0.3
====================

# Usage
To use BugVM Gradle, include in your gradle build script:

```groovy
// Pull the plugin from Maven Central
buildscript {
    repositories {
        mavenCentral()
        maven { url 'https://oss.sonatype.org/content/repositories/snapshots' }
    }
    dependencies {
        classpath 'com.bugvm:bugvm-gradle-plugin:1.0.3'
    }
}
```

Deploy
```
cd ~/bugvm/bugvm-gradle
./gradlew clean build install
./gradlew uploadArchives
```
