package com.bugvm.samples.customframeworks.ui;

import com.bugvm.apple.foundation.NSBundle;
import com.bugvm.apple.uikit.UILabel;
import com.bugvm.apple.uikit.UIStoryboard;
import com.bugvm.apple.uikit.UITextField;
import com.bugvm.apple.uikit.UIViewController;
import com.bugvm.objc.annotation.CustomClass;
import com.bugvm.objc.annotation.IBAction;
import com.bugvm.objc.annotation.IBOutlet;
import com.bugvm.samples.customframeworks.ObjCAdder;
import com.bugvm.samples.customframeworks.SwiftAdder;

@CustomClass("MyViewController")
public class MyViewController extends UIViewController {
    @IBOutlet
    private UILabel result;
    @IBOutlet
    private UITextField val1;
    @IBOutlet
    private UITextField val2;

    @Override
    public void viewDidLoad() {
        super.viewDidLoad();

        result.setText("Enter 2 numbers");

        // this just demonstrates how to load a resources
        // from a framework. The storyboard is not really used.
        NSBundle bundle = NSBundle.getBundle("com.bugvm.MySwiftFramework");
        UIStoryboard storyboard = new UIStoryboard("Storyboard", bundle);
    }

    @IBAction
    public void addViaObjc() {
        try {
            int a = Integer.parseInt(val1.getText());
            int b = Integer.parseInt(val2.getText());
            ObjCAdder adder = new ObjCAdder();
            result.setText("= " + adder.add(a, b));
        } catch (Throwable t) {
            result.setText("Check your numbers");
        }
    }

    @IBAction
    public void addViaSwift() {
        try {
            int a = Integer.parseInt(val1.getText());
            int b = Integer.parseInt(val2.getText());
            SwiftAdder adder = new SwiftAdder();
            result.setText("= " + adder.add(a, b));
        } catch (Throwable t) {
            t.printStackTrace();
            result.setText("Check your numbers");
        }
    }
}
