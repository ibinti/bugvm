package ${package};

import com.bugvm.apple.foundation.NSAutoreleasePool;
import com.bugvm.apple.uikit.UIApplication;
import com.bugvm.apple.uikit.UIApplicationDelegateAdapter;
import com.bugvm.apple.uikit.UIApplicationLaunchOptions;
import com.bugvm.apple.uikit.UIScreen;
import com.bugvm.apple.uikit.UIWindow;

public class ${mainClass} extends UIApplicationDelegateAdapter {
    private UIWindow window;
    private MyViewController rootViewController;

    @Override
    public boolean didFinishLaunching(UIApplication application, UIApplicationLaunchOptions launchOptions) {
        // Set up the view controller.
        rootViewController = new MyViewController();

        // Create a new window at screen size.
        window = new UIWindow(UIScreen.getMainScreen().getBounds());
        // Set the view controller as the root controller for the window.
        window.setRootViewController(rootViewController);
        // Make the window visible.
        window.makeKeyAndVisible();

        return true;
    }

    public static void main(String[] args) {
        NSAutoreleasePool pool=new NSAutoreleasePool();
        UIApplication.main(args,null,${mainClass}.class);
        pool.close();
    }
}
