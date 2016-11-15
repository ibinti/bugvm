# javafxmobile-plugin #

The javafxmobile-plugin is a gradle plugin that unifies the building of JavaFX applications for three different target platforms:

* desktop
* android
* ios

The currently published version is `1.1.0`.

### Getting started ###

If you need information about how to get started with the javafxmobile gradle plugin, we refer you to [Getting Started](http://javafxports.org/page/Getting_Started) page on the [javafxports.org](http://javafxports.org) website.

### External dependencies ###

The plugin will automatically download several tools to be able to make builds for the different platforms. Below is a listing of all the default dependencies:

#### Android ####

* Android SDK: the android sdk must be downloaded manually because it can not be automated in the plugin. The default android platform that is being built for is `android-21`.
* Dalvik SDK: contains the port of JavaFX 8 to android. The plugin currently depends on `org.javafxports:dalvik-sdk:8.60.8` and `org.javafxports:jfxdvk:8.60.8`.
* Retrolambda: the plugin uses the Retrolambda gradle plugin to transform the code to java 6 compatible bytecode and currently depends on `net.orfjackal.retrolambda:retrolambda:2.3.0`.

#### iOS ####
* iOS SDK: contains the port of JavaFX 8 to iOS. The plugin currently depends on `org.javafxports:ios-sdk:8.60.8`.

#### Resources ####

* JavaFX ports: https://bitbucket.org/javafxports/8u-dev-rt
* Android SDK: http://developer.android.com/sdk/index.html
* Retrolambda: https://github.com/orfjackal/retrolambda