# IntelliJ IDEA Community Edition
### Building and Running from the IDE
To develop IntelliJ IDEA, you can use either IntelliJ IDEA Community Edition or IntelliJ IDEA Ultimate. To build and run the code:
* Run **getPlugins.sh** from the project root directory to check out additional modules.
* Install the **Kotlin plugin** from the plugin manager (version 0.12.613). Parts of IntelliJ IDEA are written in Kotlin, and you need the plugin to compile the code.
* Make sure you have the **Groovy** plugin enabled. Parts of IntelliJ IDEA are written in Groovy, and you will get compilation errors if you don't have the plugin enabled.
* Make sure you have the **UI Designer** plugin enabled. Most of IntelliJ IDEA's UI is built using the **UI Designer**, and the version you build will not run correctly if you don't have the plugin enabled.
* Open the project.
* Configure a JSDK named "**IDEA jdk**" (case sensitive), pointing to an installation of JDK 1.6.
* Unless you're running on a Mac with an Apple JDK, add <JDK_HOME>/lib/tools.jar to the set of "**IDEA jdk**" jars.
* Configure a JSDK named "**1.8**", pointing to an installation of JDK 1.8.
* Add <JDK_18_HOME>/lib/tools.jar to the set of "**1.8**" jars.
* Use Build | Make Project to build the code.
* To run the code, use the provided shared run configuration "**IDEA**".

You can find other useful information at [http://www.jetbrains.org](http://www.jetbrains.org). [Contribute section](http://www.jetbrains.org/display/IJOS/Contribute) of that site describes how you can contribute to IntelliJ IDEA.

## BugVM Studio

### Prerequisits
In addition to what you need to build IDEA on the CLI, you'll also need to install `appdmg` via npm

```
npm install -g appdmg
```

This is used to create a DMG from the output of the build process.

The build scripts are located in `build-bugvm`, and are a heavily modified copy of what you find in `build`, the standard IDEA build scripts. Instead of community-main, it references the bugvm-studio-main module. Instead of community-resources it references bugvm-studio-branding, which contains all BugVM Studio relevant branding and app info.

You also need IntelliJ IDEA 15+ installed somewhere, e.g. `/Applications/IntelliJ IDEA CE.app/`

### Build
The build needs to be executed on Mac OS X as we also generate a DMG 

You need to set two environment variables:

```bash
export IDEA_HOME="/Applications/IntelliJ IDEA CE.app/Contents"
```

Once the environment variables are set, execute:

```
./studio.sh
```

This will build BugVM Studio for Mac OS X as follows:
* Pull in the latest changes to the Android plugin
* Build BugVM Studio, integrate the branding and IDEA plugin
* Create a DMG

The build output will be located in `out/bugvm` and will not be signed (see [this issue](https://github.com/bugvm/bugvm-studio/issues/3)).

### Update/Patch URLs
IntelliJ IDEA has a mechanism to inform users about new releases of the IDE. These are specified in `bugvm/bugvm-studio-branding/src/idea/IdeaApplicationInfo.xml`.
