/*
 * Copyright (C) 2013-2015 RoboVM AB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.bugvm.apple.mediaplayer;

/*<imports>*/
import java.io.*;
import java.nio.*;
import java.util.*;
import com.bugvm.objc.*;
import com.bugvm.objc.annotation.*;
import com.bugvm.objc.block.*;
import com.bugvm.rt.*;
import com.bugvm.rt.annotation.*;
import com.bugvm.rt.bro.*;
import com.bugvm.rt.bro.annotation.*;
import com.bugvm.rt.bro.ptr.*;
import com.bugvm.apple.foundation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coregraphics.*;
/*</imports>*/

/*<javadoc>*/
/**
 * @since Available in iOS 2.0 and later.
 */
/*</javadoc>*/
/*<annotations>*/@Library("MediaPlayer") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/MPVolumeView/*</name>*/ 
    extends /*<extends>*/UIView/*</extends>*/ 
    /*<implements>*/implements NSCoding/*</implements>*/ {

    public static class Notifications {
        /**
         * @since Available in iOS 7.0 and later.
         */
        public static NSObject observeWirelessRoutesAvailableDidChange(MPVolumeView object, final VoidBlock1<MPVolumeView> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(WirelessRoutesAvailableDidChangeNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke (NSNotification a) {
                    block.invoke((MPVolumeView) a.getObject());
                }
            });
        }
        /**
         * @since Available in iOS 7.0 and later.
         */
        public static NSObject observeWirelessRouteActiveDidChange(MPVolumeView object, final VoidBlock1<MPVolumeView> block) {
            return NSNotificationCenter.getDefaultCenter().addObserver(WirelessRouteActiveDidChangeNotification(), object, NSOperationQueue.getMainQueue(), new VoidBlock1<NSNotification>() {
                @Override
                public void invoke (NSNotification a) {
                    block.invoke((MPVolumeView) a.getObject());
                }
            });
        }
    }
    
    /*<ptr>*/public static class MPVolumeViewPtr extends Ptr<MPVolumeView, MPVolumeViewPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(MPVolumeView.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public MPVolumeView() {}
    protected MPVolumeView(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    public MPVolumeView(CGRect frame) {
    	super(frame);
    }
    /*<properties>*/
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Property(selector = "showsVolumeSlider")
    public native boolean showsVolumeSlider();
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Property(selector = "setShowsVolumeSlider:")
    public native void setShowsVolumeSlider(boolean v);
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Property(selector = "showsRouteButton")
    public native boolean showsRouteButton();
    /**
     * @since Available in iOS 4.2 and later.
     */
    @Property(selector = "setShowsRouteButton:")
    public native void setShowsRouteButton(boolean v);
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "areWirelessRoutesAvailable")
    public native boolean areWirelessRoutesAvailable();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "isWirelessRouteActive")
    public native boolean isWirelessRouteActive();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "volumeWarningSliderImage")
    public native UIImage getVolumeWarningSliderImage();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @Property(selector = "setVolumeWarningSliderImage:")
    public native void setVolumeWarningSliderImage(UIImage v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    /**
     * @since Available in iOS 7.0 and later.
     */
    @GlobalValue(symbol="MPVolumeViewWirelessRoutesAvailableDidChangeNotification", optional=true)
    public static native NSString WirelessRoutesAvailableDidChangeNotification();
    /**
     * @since Available in iOS 7.0 and later.
     */
    @GlobalValue(symbol="MPVolumeViewWirelessRouteActiveDidChangeNotification", optional=true)
    public static native NSString WirelessRouteActiveDidChangeNotification();
    
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setMinimumVolumeSliderImage:forState:")
    public native void setMinimumVolumeSliderImage(UIImage image, UIControlState state);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setMaximumVolumeSliderImage:forState:")
    public native void setMaximumVolumeSliderImage(UIImage image, UIControlState state);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setVolumeThumbImage:forState:")
    public native void setVolumeThumbImage(UIImage image, UIControlState state);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "minimumVolumeSliderImageForState:")
    public native UIImage getMinimumVolumeSliderImage(UIControlState state);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "maximumVolumeSliderImageForState:")
    public native UIImage getMaximumVolumeSliderImage(UIControlState state);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "volumeThumbImageForState:")
    public native UIImage getVolumeThumbImage(UIControlState state);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "volumeSliderRectForBounds:")
    public native @ByVal CGRect getVolumeSliderRect(@ByVal CGRect bounds);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "volumeThumbRectForBounds:volumeSliderRect:value:")
    public native @ByVal CGRect getVolumeThumbRect(@ByVal CGRect bounds, @ByVal CGRect rect, float value);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "setRouteButtonImage:forState:")
    public native void setRouteButtonImage(UIImage image, UIControlState state);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "routeButtonImageForState:")
    public native UIImage getRouteButtonImage(UIControlState state);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Method(selector = "routeButtonRectForBounds:")
    public native @ByVal CGRect getRouteButtonRect(@ByVal CGRect bounds);
    /*</methods>*/
}
