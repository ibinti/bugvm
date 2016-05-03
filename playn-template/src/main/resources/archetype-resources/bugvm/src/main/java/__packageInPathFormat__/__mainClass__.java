/**
 * Copyright 2014 The PlayN Authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ${package};

import com.bugvm.apple.coregraphics.CGRect;
import com.bugvm.apple.foundation.NSAutoreleasePool;
import com.bugvm.apple.uikit.UIApplication;
import com.bugvm.apple.uikit.UIApplicationDelegateAdapter;
import com.bugvm.apple.uikit.UIApplicationLaunchOptions;
import com.bugvm.apple.uikit.UIInterfaceOrientationMask;
import com.bugvm.apple.uikit.UIScreen;
import com.bugvm.apple.uikit.UIWindow;

import playn.bugvm.BugPlatform;
import playn.sample.hello.core.HelloGame;

public class ${mainClass} extends UIApplicationDelegateAdapter {

  @Override
  public boolean didFinishLaunching (UIApplication app, UIApplicationLaunchOptions launchOpts) {
    // create a full-screen window
    CGRect bounds = UIScreen.getMainScreen().getBounds();
    UIWindow window = new UIWindow(bounds);

    // create and initialize the PlayN platform
    BugPlatform.Config config = new BugPlatform.Config();
    config.orients = UIInterfaceOrientationMask.All;
    BugPlatform pf = BugPlatform.create(window, config);

    // create our game
    new HelloGame(pf);

    // make our main window visible (the platform starts when the window becomes viz)
    window.makeKeyAndVisible();
    return true;
  }

  public static void main (String[] args) {
    NSAutoreleasePool pool = new NSAutoreleasePool();
    UIApplication.main(args, null, ${mainClass}.class);
    pool.close();
  }
}
