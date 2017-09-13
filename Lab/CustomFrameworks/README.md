# Custom Frameworks Sample
This sample demonstrates the use of custom Objective-C & Swift dynamic frameworks. The folders `MyObjectiveCFramework` and `MySwiftFramework` contain two simple Xcode projects. Each implements a simple class with a single method `add()` that adds two integers and returns the result. The projects were created using the default Xcode Cocoa Touch Framework template.

To run the BugVM app, you need to invoke `build-frameworks.sh` first. This script will build the dynamic frameworks for both Xcode projects and place the resulting framework in `MyObjectiveCFramework/build/MyObjectiveCFramework.framework` and `MySwiftFramework/build/MySwiftFramework.framework`. The dynamic libraries in those folders contain slices for all iOS architectures.

The `bugvm.xml` file specifies the `build/` directories as framework paths and also specifies the frameworks themselves to be linked. At build time, BugVM will copy the frameworks to the `Frameworks/` folder in the app bundle, including Swift runtime libraries automatically.

The BugVM app is a simple user interface that lets the user enter two numbers and then calculate their sum either via the Swift or Objective-C implementation of the adder class. The classes are bound via their Java Bro brindings in `ObjCAdder.java` and `SwiftAdder.java`.