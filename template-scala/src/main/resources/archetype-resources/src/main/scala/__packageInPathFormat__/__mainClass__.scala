package ${package}

import com.bugvm.apple.foundation.NSAutoreleasePool
import com.bugvm.apple.uikit._

class AppDelegate extends UIApplicationDelegateAdapter {
  lazy val window = new UIWindow(UIScreen.getMainScreen.getBounds)

  override def didFinishLaunching(application: UIApplication, launchOptions: UIApplicationLaunchOptions) = {
    window.setRootViewController(new ScalaViewController)
    //window.setRootViewController(new JavaViewController)
    window.makeKeyAndVisible
    true
  }
}

object ${mainClass} extends App {
  val pool = new NSAutoreleasePool
  UIApplication.main(args, null, classOf[AppDelegate])
  pool.close
}