# Chapter 72. Building native software

To build native software using Gradle, your project should define one or more native components. Each component represents either an executable or a library that Gradle should build. A project can define any number of components. Gradle does not define any components by default. 

For each component, Gradle defines a source set for each language that the component can be built from. A source set is essentially just a set of source directories containing source files. For example, when you apply the `c` plugin and define a library called `helloworld`, Gradle will define, by default, a source set containing the C source files in the `src/helloworld/c` directory. It will use these source files to build the `helloworld` library.

For each component, Gradle defines one or more binaries as output. To build a binary, Gradle will take the source files defined for the component, compile them as appropriate for the source language, and link the result into a binary file. For an executable component, Gradle can produce executable binary files. For a library component, Gradle can produce both static and shared library binary files. For example, when you define a library called `helloworld` and build on Linux, Gradle will, by default, produce `libhelloworld.so` and `libhelloworld.a` binaries.

In many cases, more than one binary can be produced for a component. These binaries may vary based on the tool chain used to build, the compiler/linker flags supplied, the dependencies provided, or additional source files provided. Each native binary produced for a component is referred to as a `variant`.

# 72.7. Building a library

To build either a static or shared native library, you define a library component in the components container. The following sample defines a library called `hello`:

Example 72.1. Defining a library component

```
build.gradle

model {
    components {
        hello(NativeLibrarySpec)
    }
}
```

A library component is represented using `NativeLibrarySpec`. Each library component can produce at least one shared library binary (`SharedLibraryBinarySpec`) and at least one static library binary (`StaticLibraryBinarySpec`). 

[to be continued: native_software.html](https://docs.gradle.org/current/userguide/native_software.html)