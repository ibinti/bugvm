# Experiments on JavaCPP Presets

Experiments on JavaCPP Presets

```
mvn clean install
```

# Maven plugin to Gradle plugin
One cannot use a Maven plugin as-is in Gradle. 
It has to be ported to a Gradle plugin. 
Until that happens, one workaround is to run Maven plugin with Gradle's Exec task.
 
```
pom.xml
...
<plugin>
<groupId>com.bugvm</groupId>
<artifactId>javacpp</artifactId>
</plugin>
...
```