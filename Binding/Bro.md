
## Bro
Bro is an API that enables Java code to call directly into native code without using JNI.
Let's introduce bro with the most simple example possible:

    import com.bugvm.rt.bro.*;
    import com.bugvm.rt.bro.annotation.*;
    
    @Library("c")
    public class Abs {
        static {
            Bro.bind();
        }
        @Bridge private static native int abs(int i);
        public static void main(String[] args) {
            System.out.println(abs(-100));
        }
    }

This example binds the `Abs.abs()` method to the `abs(int)` function in the `libc` system library.
The `@Library` class annotation specifies which dynamic library bro should use to bind the `@Bridge` 
annotated methods in the class to (bro will prepend `lib` and append `.so` to the specified library 
name when searching for a matching library). The call to `Bro.bind()` in the static initializer binds 
the `@Bridge` methods when the `Abs` class is loaded. During binding bro will use `dlopen` 
and `dlsym` to resolve the `@Bridge` annotated methods. If the `@Bridge` annotation doesn't specify 
the symbol to bind to the method name will be used.

<br/>

## Mapping of primitive types

Native integer types (`char`, `int32_t`, `float`) are mapped to Java integer types of the same size:
        
    | Java | Bits | Example C type (depends on compiler and platform) |
    |:-------|---:|:----|
    | byte   |  8 | char, uint8_t
    | short  | 16 | short
    | char   | 16 | uint16_t
    | int    | 32 | int, int32_t
    | long   | 64 | long long, int64_t

Note that unsigned types (e.g. `uint32_t`) are mapped to the signed Java type of the same size.
Native `float` maps to Java's `float` and native `double` maps to Java's `double`.

## Pointers

The simplest way to map a pointer is either pass it in a Java `int` (assumes 32-bit pointers) or 
as a Java `long` annotated with `@Pointer`. The bro compiler will handle the 64-bit to 32-bit 
conversions if the target architecture uses 32-bit pointers. Here's an example that calls `getenv(char*)`
to get the value of the `HOME` environment variable:
        
    import com.bugvm.rt.*;
    import com.bugvm.rt.bro.*;
    import com.bugvm.rt.bro.annotation.*;
    
    @Library("c")
    public class Getenv1 {
        static {
            Bro.bind();
        }
        @Bridge private static native @Pointer long getenv(@Pointer long name);
        public static void main(String[] args) {
            long name = VM.getStringUTFChars("HOME");
            long value = getenv(name);
            System.out.println(VM.newStringUTF(value));
        }
    }

This example uses the `com.bugvm.rt.VM` class to convert zero-terminated C strings into Java `String` 
objects. Bro provides special pointer classes for each of the Java primitive types which we can use 
to make this example look nicer:

    import com.bugvm.rt.bro.*;
    import com.bugvm.rt.bro.annotation.*;
    import com.bugvm.rt.bro.ptr.*;
    
    @Library("c")
    public class Getenv2 {
        static {
            Bro.bind();
        }
        @Bridge private static native BytePtr getenv(BytePtr name);
        public static void main(String[] args) {
            System.out.println(getenv(BytePtr.toBytePtrAsciiZ("HOME")).toStringAsciiZ());
        }
    }

## Structs

C `struct` types are mapped to Java by extending the bro `Struct` class. `Struct` classes must be 
`final`. Each member of the C struct is mapped by a getter method and a setter method that must be 
annotated with the bro `@StructMember` annotation and given the index of the member in the struct. 
The names of the getter and setter can follow the Java Beans style convention for Java Beans 
properties but doesn't have to. Here's a simple example which maps `struct timeval` and calls `gettimeofday()`:
        
    import com.bugvm.rt.bro.*;
    import com.bugvm.rt.bro.annotation.*;
    import com.bugvm.rt.bro.ptr.*;
    
    @Library("c")
    public class Gettimeofday {
    
        public static final class Timeval extends Struct {
            @StructMember(0)
            public native int tv_sec();
            @StructMember(0)
            public native void tv_sec(int i);
            @StructMember(1)
            public native int tv_usec();
            @StructMember(1)
            public native void tv_usec(int i);
        }
    
        static {
            Bro.bind();
        }
        @Bridge private static native int gettimeofday(@ByRef Timeval tp, VoidPtr tzp);
        public static void main(String[] args) {
            Timeval t = new Timeval();
            gettimeofday(t, null);
            System.out.format("Seconds since epoch: %dn", t.tv_sec());
        }
    }

The type of the struct member is determined by the return value of the getter and the single argument 
of the setter method (these have to be identical). The setter must either return no value 
(i.e. `void`) or return the `Struct` type itself. The latter style makes it possible to chain setter calls.

The `@ByRef` and `@ByVal` annotations can be used to control how a `Struct` object is returned from 
a method or passed as a parameter to a method. `@ByRef` means pass as pointer and is the default. 
`@ByVal` means pass by value. The default can be changed to `@ByVal` for a particular `Struct` class 
by annotating the class with `@ByVal`.

`Struct` classes can contain other `Struct` objects as members, either by value or by reference 
(i.e. by pointer). The default is `@ByRef` with the same possibilities to override the default as 
for methods.

Here's an example of how the Cocoa Touch `struct CGRect` type is mapped to Java in the BugVM Cocoa 
Touch bindings:

C:

    struct CGRect {
        CGPoint origin;
        CGSize size;
    };

Java:

    import com.bugvm.rt.bro.*;
    import com.bugvm.rt.bro.annotation.*;
    
    public final class CGRect extends Struct {
        public CGRect() {}
        public CGRect(float x, float y, float width, float height) {
            origin().x(x).y(y);
            size().width(width).height(height);
        }
        public CGRect(CGPoint origin, CGSize size) {
            origin(origin);
            size(size);
        }
    
        @StructMember(0)
        public native @ByVal CGPoint origin();
        @StructMember(0)
        public native void origin(@ByVal CGPoint origin);
        @StructMember(1)
        public native @ByVal CGSize size();
        @StructMember(1)
        public native void size(@ByVal CGSize size);
    }

## Memory handling

When creating an instance of a `Struct` class bro actually allocates two memory regions. One for the 
Java object and one for the struct data. The default is to allocate the struct data on the Java heap. 
This means that the data will be garbage collected when the garbage collector determines that the 
struct data isn't referenced from any other memory allocated on the garbage collected heap. This 
won't work for native code that holds on to reference beyond a native function call since the native 
heap is unknown to the garbage collector. If the native function calls `free()` on the memory when 
it's done with it the Java side has to use `malloc()` to allocate it on the native heap. E.g.:

    MyStruct p = Struct.malloc(MyStruct.class);

If the native side holds on to a memory region allocated on the GCed heap care must be taken on the 
Java side to make sure that memory isn't collected until the native side is done with it. As long as 
the Java `Struct` instance is referenced on the Java side the struct data can't be collected.

The memory region allocated to hold a struct's data will always be zeroed out no matter if using the 
Java heap or the native heap.

## Native arrays

Here's an example of how to allocate an array of a `Struct` type `MyStruct`:

    MyStruct l = Struct.allocate(MyStruct.class, 10);

This allocates a contiguous memory region big enough to hold 10 `MyStruct` instances. The `Struct` 
class defines a number of methods that can be used to iterate over these, e.g. `next()` and `previous()`. 
`Struct` also implements the `Iterable` interface:

    for (MyStruct o : l) {
        ...
        if (l.someMember() == 100) {
            break;
        }
    }

Note that the `Iterator` used when `for`-looping like this is unbounded so a `break` is required to 
finish the loop.

The `BytePtr` class we saw earlier and the other pointer classes in `com.bugvm.rt.bro.ptr` are in 
fact `Struct` classes as well so to allocate a native array of 100 `int` values one could do:

    IntPtr myInts = Struct.allocate(IntPtr.class, 100);

## Unbounded native array members

For unbounded native array members one should use one of the pointer classes in the 
`com.bugvm.rt.bro.ptr` package combined with the `@ByVal` annotation:

C:

    struct PascalString {
        int length;
        char chars[];
    };

Java:

    public class PascalString extends Struct {
        @StructMember(0) public native int length();
        @StructMember(0) public native void length(int length);
        @StructMember(0) public native @ByVal BytePtr chars();
    }
        
There's no setter for the chars member as that would have required the length to be known at compile 
time. Setting the individual bytes of chars has to be done through the `BytePtr` returned by the getter.

## Enums

Simple C enums are mapped using Java `Enum` types which implement the bro `ValuedEnum` interface. 
Here's an example:

C:

    enum {
       NSTextAlignmentLeft      = 0,
       NSTextAlignmentCenter    = 1,
       NSTextAlignmentRight     = 2,
       NSTextAlignmentJustified = 3,
       NSTextAlignmentNatural   = 4,
    };

Java:

    import com.bugvm.rt.bro.ValuedEnum;
    
    public enum NSTextAlignment implements ValuedEnum {
        Left(0),
        Center(1),
        Right(2),
        Justified(3),
        Natural(4);
    
        private final long n;
    
        private NSTextAlignment(long n) { this.n = n; }
        public long value() { return n; }
    }

## Callback methods
        
Java:

    CallbackTest test = new CallbackTest();
    
    @Callback
    public static void callbackMethod(NSData inBuffer) {
        System.out.println("callbackMethod");
    }
    
    try {
        Method callbackMethod = this.getClass().getDeclaredMethod("callbackMethod", NSData.class);
        test.nativeSetCallback(new FunctionPtr(callbackMethod));
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    }
    
    @Callback
    public static void callbackMethod2(int p1, int p2) {
        System.out.println("callbackMethod2 "+p1+"-"+p2);
    }
    
    try {
        Method callbackMethod2 = this.getClass().getDeclaredMethod("callbackMethod2", int.class, int.class);
        test.nativeSetCallback2(new FunctionPtr(callbackMethod2));
    } catch (NoSuchMethodException e) {
        e.printStackTrace();
    }

    @Library(Library.INTERNAL)
    @NativeClass
    public class CallbackTest extends NSObject {
    
        static { ObjCRuntime.bind(); }
    
        @Method(selector = "setCallback:")
        public native void nativeSetCallback(FunctionPtr callback);
    
        @Method(selector = "setCallback2:")
        public native void nativeSetCallback2(FunctionPtr callback);
    
    }

Objective-C

    typedef void (*MyCallback)(NSData* data);
    typedef void (*MyCallback2)(SInt32 p1, SInt32 p2);
    @interface CallbackTest : NSObject {
        MyCallback myCallback;
        MyCallback2 myCallback2;
    }
    - (void) setCallback:(MyCallback) callback;
    - (void) setCallback2:(MyCallback2) callback;
    - (void) testCall;
    - (void) testCall2;
    @end

    @implementation CallbackTest
    - (void) setCallback:(MyCallback) callback {
        myCallback = callback;
    }
    - (void) setCallback2:(MyCallback2) callback {
        myCallback2 = callback;
    }
    
    - (void) testCall {
        short *byteData= (short*)malloc(1024);
        NSData* data = [[NSData alloc] initWithBytes:byteData length:1024];
        myCallback(data);
        [data getBytes:byteData];
    }
    
    - (void) testCall2 {
        myCallback2(123,4567);
    }
    @end
