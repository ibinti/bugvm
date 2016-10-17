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

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("Foundation") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSDateFormatter/*</name>*/ 
    extends /*<extends>*/NSFormatter/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class NSDateFormatterPtr extends Ptr<NSDateFormatter, NSDateFormatterPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSDateFormatter.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public NSDateFormatter() {}
    protected NSDateFormatter(SkipInit skipInit) { super(skipInit); }
    /*</constructors>*/
    /*<properties>*/
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "formattingContext")
    public native NSFormattingContext getFormattingContext();
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Property(selector = "setFormattingContext:")
    public native void setFormattingContext(NSFormattingContext v);
    @Property(selector = "dateFormat")
    public native String getDateFormat();
    @Property(selector = "setDateFormat:")
    public native void setDateFormat(String v);
    @Property(selector = "dateStyle")
    public native NSDateFormatterStyle getDateStyle();
    @Property(selector = "setDateStyle:")
    public native void setDateStyle(NSDateFormatterStyle v);
    @Property(selector = "timeStyle")
    public native NSDateFormatterStyle getTimeStyle();
    @Property(selector = "setTimeStyle:")
    public native void setTimeStyle(NSDateFormatterStyle v);
    @Property(selector = "locale")
    public native NSLocale getLocale();
    @Property(selector = "setLocale:")
    public native void setLocale(NSLocale v);
    @Property(selector = "generatesCalendarDates")
    public native boolean generatesCalendarDates();
    @Property(selector = "setGeneratesCalendarDates:")
    public native void setGeneratesCalendarDates(boolean v);
    @Property(selector = "formatterBehavior")
    public native NSDateFormatterBehavior getFormatterBehavior();
    @Property(selector = "setFormatterBehavior:")
    public native void setFormatterBehavior(NSDateFormatterBehavior v);
    @Property(selector = "timeZone")
    public native NSTimeZone getTimeZone();
    @Property(selector = "setTimeZone:")
    public native void setTimeZone(NSTimeZone v);
    @Property(selector = "calendar")
    public native NSCalendar getCalendar();
    @Property(selector = "setCalendar:")
    public native void setCalendar(NSCalendar v);
    @Property(selector = "isLenient")
    public native boolean isLenient();
    @Property(selector = "setLenient:")
    public native void setLenient(boolean v);
    @Property(selector = "twoDigitStartDate")
    public native NSDate getTwoDigitStartDate();
    @Property(selector = "setTwoDigitStartDate:")
    public native void setTwoDigitStartDate(NSDate v);
    @Property(selector = "defaultDate")
    public native NSDate getDefaultDate();
    @Property(selector = "setDefaultDate:")
    public native void setDefaultDate(NSDate v);
    @Property(selector = "eraSymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getEraSymbols();
    @Property(selector = "setEraSymbols:")
    public native void setEraSymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    @Property(selector = "monthSymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getMonthSymbols();
    @Property(selector = "setMonthSymbols:")
    public native void setMonthSymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    @Property(selector = "shortMonthSymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getShortMonthSymbols();
    @Property(selector = "setShortMonthSymbols:")
    public native void setShortMonthSymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    @Property(selector = "weekdaySymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getWeekdaySymbols();
    @Property(selector = "setWeekdaySymbols:")
    public native void setWeekdaySymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    @Property(selector = "shortWeekdaySymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getShortWeekdaySymbols();
    @Property(selector = "setShortWeekdaySymbols:")
    public native void setShortWeekdaySymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    @Property(selector = "AMSymbol")
    public native String getAMSymbol();
    @Property(selector = "setAMSymbol:")
    public native void setAMSymbol(String v);
    @Property(selector = "PMSymbol")
    public native String getPMSymbol();
    @Property(selector = "setPMSymbol:")
    public native void setPMSymbol(String v);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "longEraSymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getLongEraSymbols();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "setLongEraSymbols:")
    public native void setLongEraSymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "veryShortMonthSymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getVeryShortMonthSymbols();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "setVeryShortMonthSymbols:")
    public native void setVeryShortMonthSymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "standaloneMonthSymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getStandaloneMonthSymbols();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "setStandaloneMonthSymbols:")
    public native void setStandaloneMonthSymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "shortStandaloneMonthSymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getShortStandaloneMonthSymbols();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "setShortStandaloneMonthSymbols:")
    public native void setShortStandaloneMonthSymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "veryShortStandaloneMonthSymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getVeryShortStandaloneMonthSymbols();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "setVeryShortStandaloneMonthSymbols:")
    public native void setVeryShortStandaloneMonthSymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "veryShortWeekdaySymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getVeryShortWeekdaySymbols();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "setVeryShortWeekdaySymbols:")
    public native void setVeryShortWeekdaySymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "standaloneWeekdaySymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getStandaloneWeekdaySymbols();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "setStandaloneWeekdaySymbols:")
    public native void setStandaloneWeekdaySymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "shortStandaloneWeekdaySymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getShortStandaloneWeekdaySymbols();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "setShortStandaloneWeekdaySymbols:")
    public native void setShortStandaloneWeekdaySymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "veryShortStandaloneWeekdaySymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getVeryShortStandaloneWeekdaySymbols();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "setVeryShortStandaloneWeekdaySymbols:")
    public native void setVeryShortStandaloneWeekdaySymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "quarterSymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getQuarterSymbols();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "setQuarterSymbols:")
    public native void setQuarterSymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "shortQuarterSymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getShortQuarterSymbols();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "setShortQuarterSymbols:")
    public native void setShortQuarterSymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "standaloneQuarterSymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getStandaloneQuarterSymbols();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "setStandaloneQuarterSymbols:")
    public native void setStandaloneQuarterSymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "shortStandaloneQuarterSymbols")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getShortStandaloneQuarterSymbols();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "setShortStandaloneQuarterSymbols:")
    public native void setShortStandaloneQuarterSymbols(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> v);
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "gregorianStartDate")
    public native NSDate getGregorianStartDate();
    /**
     * @since Available in iOS 2.0 and later.
     */
    @Property(selector = "setGregorianStartDate:")
    public native void setGregorianStartDate(NSDate v);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "doesRelativeDateFormatting")
    public native boolean doesRelativeDateFormatting();
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Property(selector = "setDoesRelativeDateFormatting:")
    public native void setDoesRelativeDateFormatting(boolean v);
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "stringFromDate:")
    public native String format(NSDate date);
    @Method(selector = "dateFromString:")
    public native NSDate parse(String string);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "setLocalizedDateFormatFromTemplate:")
    public native void setLocalizedDateFormat(String dateFormatTemplate);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "localizedStringFromDate:dateStyle:timeStyle:")
    public static native String format(NSDate date, NSDateFormatterStyle dstyle, NSDateFormatterStyle tstyle);
    /**
     * @since Available in iOS 4.0 and later.
     */
    @Method(selector = "dateFormatFromTemplate:options:locale:")
    public static native String getDateFormatFromTemplate(String tmplate, @MachineSizedUInt long opts, NSLocale locale);
    @Method(selector = "defaultFormatterBehavior")
    public static native NSDateFormatterBehavior getDefaultFormatterBehavior();
    @Method(selector = "setDefaultFormatterBehavior:")
    public static native void setDefaultFormatterBehavior(NSDateFormatterBehavior behavior);
    /*</methods>*/
}
