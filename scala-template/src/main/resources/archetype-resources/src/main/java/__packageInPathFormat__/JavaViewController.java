package ${package};

import com.bugvm.apple.coregraphics.CGRect;
import com.bugvm.apple.uikit.NSTextAlignment;
import com.bugvm.apple.uikit.UIButton;
import com.bugvm.apple.uikit.UIButtonType;
import com.bugvm.apple.uikit.UIColor;
import com.bugvm.apple.uikit.UIControl;
import com.bugvm.apple.uikit.UIControlState;
import com.bugvm.apple.uikit.UIEvent;
import com.bugvm.apple.uikit.UIFont;
import com.bugvm.apple.uikit.UILabel;
import com.bugvm.apple.uikit.UIView;
import com.bugvm.apple.uikit.UIViewController;

public class JavaViewController extends UIViewController {
    private final UIButton button;
    private final UILabel label;
    private int clickCount;

    public JavaViewController() {
        // Get the view of this view controller.
        UIView view = getView();

        // Setup background.
        view.setBackgroundColor(UIColor.white());

        // Setup label.
        label = new UILabel(new CGRect(20, 250, 280, 44));
        label.setFont(UIFont.getSystemFont(24));
        label.setTextAlignment(NSTextAlignment.Center);
        view.addSubview(label);

        // Setup button.
        button = new UIButton(UIButtonType.RoundedRect);
        button.setFrame(new CGRect(60, 150, 200, 40));
        button.setTitle("Click Java!", UIControlState.Normal);
        button.getTitleLabel().setFont(UIFont.getBoldSystemFont(22));

        button.addOnTouchUpInsideListener(new UIControl.OnTouchUpInsideListener() {
            @Override
            public void onTouchUpInside (UIControl control, UIEvent event) {
                label.setText("Click Count = " + (++clickCount));
            }
        });
        view.addSubview(button);
    }
}
