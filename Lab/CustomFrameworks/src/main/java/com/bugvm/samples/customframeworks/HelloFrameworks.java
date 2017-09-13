package com.bugvm.samples.customframeworks;

import com.bugvm.apple.foundation.NSAutoreleasePool;
import com.bugvm.apple.uikit.UIApplication;
import com.bugvm.apple.uikit.UIApplicationDelegateAdapter;

public class HelloFrameworks extends UIApplicationDelegateAdapter {
    public static void main (String[] args) {
        try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
            UIApplication.main(args, null, HelloFrameworks.class);
        }
    }
}
