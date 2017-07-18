@org.bytedeco.javacpp.annotation.Platform(include="NativeLibrary.h")
@org.bytedeco.javacpp.annotation.Namespace("NativeLibrary")
public class NativeLibrary {
    public static class NativeClass extends org.bytedeco.javacpp.Pointer {
//        static { org.bytedeco.javacpp.Loader.load(); }
        static { System.load("lib.o"); }
        public NativeClass() { allocate(); }
        private native void allocate();

        // to call the getter and setter functions
        public native @org.bytedeco.javacpp.annotation.StdString String get_property();
        public native void set_property(String property);

        // to access the member variable directly
        public native @org.bytedeco.javacpp.annotation.StdString String property();
        public native void property(String property);
    }

    public static void main(String[] args) {
        // Pointer objects allocated in Java get deallocated once they become unreachable,
        // but C++ destructors can still be called in a timely fashion with Pointer.deallocate()
        NativeClass l = new NativeClass();
        l.set_property("Hello javacpp!\nAwesome");
        System.out.println(l.property());
    }
    public static void test() {
        // Pointer objects allocated in Java get deallocated once they become unreachable,
        // but C++ destructors can still be called in a timely fashion with Pointer.deallocate()
        NativeClass l = new NativeClass();
        l.property("Hello javacpp!\nTest");
        System.out.println(l.get_property());
    }

}