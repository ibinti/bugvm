package ${package};

import com.bugvm.apple.foundation.NSAutoreleasePool;
import com.bugvm.apple.uikit.UIApplication;

import com.badlogic.gdx.backends.iosbugvm.IOSApplication;
import com.badlogic.gdx.backends.iosbugvm.IOSApplicationConfiguration;

public class ${mainClass} extends IOSApplication.Delegate {
    @Override
    protected IOSApplication createApplication() {
        IOSApplicationConfiguration config = new IOSApplicationConfiguration();
        return new IOSApplication(new MyGdxGame(), config);
    }

    public static void main(String[] argv) {
        NSAutoreleasePool pool = new NSAutoreleasePool();
        UIApplication.main(argv, null, ${mainClass}.class);
        pool.close();
    }
}