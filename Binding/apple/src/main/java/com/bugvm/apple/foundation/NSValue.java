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
package com.bugvm.apple.foundation;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
import com.bugvm.apple.coreanimation.*;
import com.bugvm.apple.coredata.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.security.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/
import com.bugvm.apple.corelocation.CLLocationCoordinate2D;
import com.bugvm.apple.mapkit.MKCoordinateSpan;
import com.bugvm.apple.scenekit.SCNMatrix4;
import com.bugvm.apple.scenekit.SCNVector3;
import com.bugvm.apple.scenekit.SCNVector4;

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass @WeaklyLinked/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSValue/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSValuePtr extends Ptr<NSValue, NSValuePtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSValue.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected NSValue(SkipInit skipInit) { super(skipInit); }
    public NSValue(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    /*<properties>*/
    @Property(selector = "objCType")
    public native @com.bugvm.rt.bro.annotation.Marshaler(StringMarshalers.AsAsciiZMarshaler.class) String getObjCType();
    @Property(selector = "nonretainedObjectValue")
    public native NSObject objectValue();
    @Property(selector = "pointerValue")
    public native @Pointer long pointerValue();
    @Property(selector = "rangeValue")
    public native @ByVal NSRange rangeValue();
    /*</properties>*/
    /*<members>*//*</members>*/

    public static NSValue valueOf(VoidPtr value, String type) {
        BytePtr p = type == null ? null : BytePtr.toBytePtrAsciiZ(type);
        return valueOf(value, p);
    }

    public VoidPtr getValue() {
        VoidPtr ptr = new VoidPtr();
        getValue(ptr);
        return ptr;
    }
    
    /* UIKit Extensions */
    @WeaklyLinked
    public CGPoint pointValue() {
        return com.bugvm.apple.uikit.NSValueExtensions.getPointValue(this);
    }
    @WeaklyLinked
    public CGSize sizeValue() {
        return com.bugvm.apple.uikit.NSValueExtensions.getSizeValue(this);
    }
    @WeaklyLinked
    public CGRect rectValue() {
        return com.bugvm.apple.uikit.NSValueExtensions.getRectValue(this);
    }
    @WeaklyLinked
    public CGAffineTransform affineTransformValue() {
        return com.bugvm.apple.uikit.NSValueExtensions.getAffineTransformValue(this);
    }
    @WeaklyLinked
    public UIEdgeInsets edgeInsetsValue() {
        return com.bugvm.apple.uikit.NSValueExtensions.getEdgeInsetsValue(this);
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    public UIOffset offsetValue() {
        return com.bugvm.apple.uikit.NSValueExtensions.getOffsetValue(this);
    }

    @WeaklyLinked
    public static NSValue valueOf(CGPoint point) {
        return com.bugvm.apple.uikit.NSValueExtensions.create(point);
    }
    @WeaklyLinked
    public static NSValue valueOf(CGSize size) {
        return com.bugvm.apple.uikit.NSValueExtensions.create(size);
    }
    @WeaklyLinked
    public static NSValue valueOf(CGRect rect) {
        return com.bugvm.apple.uikit.NSValueExtensions.create(rect);
    }
    @WeaklyLinked
    public static NSValue valueOf(CGAffineTransform transform) {
        return com.bugvm.apple.uikit.NSValueExtensions.create(transform);
    }
    @WeaklyLinked
    public static NSValue valueOf(UIEdgeInsets insets) {
        return com.bugvm.apple.uikit.NSValueExtensions.create(insets);
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    @WeaklyLinked
    public static NSValue valueOf(UIOffset insets) {
        return com.bugvm.apple.uikit.NSValueExtensions.create(insets);
    }
    
    /* AVFoundation extensions */
    /**
     * @since Available in iOS 4.0 and later.
     */
    @WeaklyLinked
    public CMTime timeValue() {
        return com.bugvm.apple.avfoundation.NSValueExtensions.getCMTimeValue(this);
    }
    /**
     * @since Available in iOS 4.0 and later.
     */
    @WeaklyLinked
    public CMTimeRange timeRangeValue() {
        return com.bugvm.apple.avfoundation.NSValueExtensions.getCMTimeRangeValue(this);
    }
    /**
     * @since Available in iOS 4.0 and later.
     */
    @WeaklyLinked
    public CMTimeMapping timeMappingValue() {
        return com.bugvm.apple.avfoundation.NSValueExtensions.getCMTimeMappingValue(this);
    }
    /**
     * @since Available in iOS 4.0 and later.
     */
    @WeaklyLinked
    public static NSValue valueOf(CMTime time) {
        return com.bugvm.apple.avfoundation.NSValueExtensions.create(time);
    }
    /**
     * @since Available in iOS 4.0 and later.
     */
    @WeaklyLinked
    public static NSValue valueOf(CMTimeRange timeRange) {
        return com.bugvm.apple.avfoundation.NSValueExtensions.create(timeRange);
    }
    /**
     * @since Available in iOS 4.0 and later.
     */
    @WeaklyLinked
    public static NSValue valueOf(CMTimeMapping timeMapping) {
        return com.bugvm.apple.avfoundation.NSValueExtensions.create(timeMapping);
    }
    
    /* CoreAnimation extensions */
    @WeaklyLinked
    public CATransform3D transform3DValue() {
        return com.bugvm.apple.coreanimation.NSValueExtensions.getCATransform3DValue(this);
    }
    @WeaklyLinked
    public static NSValue valueOf(CATransform3D t) {
        return com.bugvm.apple.coreanimation.NSValueExtensions.create(t);
    }
    
    /* MapKit extensions */
    @WeaklyLinked
    public CLLocationCoordinate2D coordinateValue() {
        return com.bugvm.apple.mapkit.NSValueExtensions.getMKCoordinateValue(this);
    }
    @WeaklyLinked
    public MKCoordinateSpan getCoordinateSpanValue() {
        return com.bugvm.apple.mapkit.NSValueExtensions.getMKCoordinateSpanValue(this);
    }
    @WeaklyLinked
    public static NSValue valueOf(CLLocationCoordinate2D coordinate) {
        return com.bugvm.apple.mapkit.NSValueExtensions.create(coordinate);
    }
    @WeaklyLinked
    public static NSValue valueOf(MKCoordinateSpan span) {
        return com.bugvm.apple.mapkit.NSValueExtensions.create(span);
    }
    
    /* SceneKit extensions */
    @WeaklyLinked
    public SCNVector3 SCNVector3Value() {
        return com.bugvm.apple.scenekit.NSValueExtensions.getSCNVector3Value(this);
    }
    @WeaklyLinked
    public SCNVector4 SCNVector4Value() {
        return com.bugvm.apple.scenekit.NSValueExtensions.getSCNVector4Value(this);
    }
    @WeaklyLinked
    public SCNMatrix4 SCNMatrix4Value() {
        return com.bugvm.apple.scenekit.NSValueExtensions.getSCNMatrix4Value(this);
    }
    @WeaklyLinked
    public static NSValue valueOf(SCNVector3 vector3) {
        return com.bugvm.apple.scenekit.NSValueExtensions.create(vector3);
    }
    @WeaklyLinked
    public static NSValue valueOf(SCNVector4 vector4) {
        return com.bugvm.apple.scenekit.NSValueExtensions.create(vector4);
    }
    @WeaklyLinked
    public static NSValue valueOf(SCNMatrix4 matrix4) {
        return com.bugvm.apple.scenekit.NSValueExtensions.create(matrix4);
    }
    /*<methods>*/
    @Method(selector = "getValue:")
    protected native void getValue(VoidPtr value);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    @Method(selector = "valueWithBytes:objCType:")
    public static native NSValue valueOf(VoidPtr value, BytePtr type);
    @Method(selector = "isEqualToValue:")
    public native boolean equalsTo(NSValue value);
    @Method(selector = "valueWithNonretainedObject:")
    public static native NSValue valueOf(NSObject anObject);
    @Method(selector = "valueWithPointer:")
    public static native NSValue valueOf(VoidPtr pointer);
    @Method(selector = "valueWithRange:")
    public static native NSValue valueOf(@ByVal NSRange range);
    /*</methods>*/
}
