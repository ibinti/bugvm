package ${package}

import com.bugvm.apple.coregraphics.CGRect
import com.bugvm.apple.uikit._

class ScalaViewController extends UIViewController {
  lazy val button = new UIButton(UIButtonType.RoundedRect)
  lazy val label = new UILabel(new CGRect(20, 200, 280, 44))
  var clickCount:Int = 0

  override def viewDidLoad() {
    getView.setBackgroundColor(UIColor.green)

    button.setFrame(new CGRect(60, 150, 200, 40))
    button.setTitle("Click Scala!", UIControlState.Normal)
    button.getTitleLabel().setFont(UIFont.getBoldSystemFont(22))
    button.addOnTouchUpInsideListener(new UIControl.OnTouchUpInsideListener() {
      override def onTouchUpInside(uiControl: UIControl, uiEvent: UIEvent) {
        clickCount += 1
        label.setText("Click Count = " + clickCount)
      }
    })
    getView.addSubview(button)

    label.setFont(UIFont.getFont("Helvetica", 24))
    label.setTextColor(UIColor.black)
    label.setBaselineAdjustment(UIBaselineAdjustment.AlignCenters)
    label.setTextAlignment(NSTextAlignment.Center)
    getView.addSubview(label)
  }
}