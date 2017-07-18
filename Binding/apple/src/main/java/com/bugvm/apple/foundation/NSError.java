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
@ForceLinkClass(NSErrorUserInfo.class)
@Marshaler(NSError.Marshaler.class)
/*<visibility>*/public/*</visibility>*/ class /*<name>*/NSError/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    public static class Marshaler {
        @MarshalsPointer
        public static NSError toObject(Class<? extends NSError> cls, long handle, long flags) {
            if (handle == 0) {
                return null;
            }
            String domain = domain(handle);
            Class<? extends NSError> nsErrorClass = allNSErrorClasses.get(domain);
            if (nsErrorClass != null) {
                cls = nsErrorClass;
            }
            NSError o = (NSError) ObjCObject.toObjCObject(cls, handle, 0, true);
            return o;
        }
        @MarshalsPointer
        public static long toNative(NSError o, long flags) {
            if (o == null) {
                return 0L;
            }
            return o.getHandle();
        }
    }
    
    private static final Map<String, Class<? extends NSError>> allNSErrorClasses = new HashMap<>();
    private static final int ABSTRACT = 0x00000400;
    
    static {
        @SuppressWarnings("unchecked")
        Class<? extends NSError>[] classes = (Class<? extends NSError>[]) 
                VM.listClasses(NSError.class, ClassLoader.getSystemClassLoader());
        Class<?>[] emptyArgs = new Class<?>[0];
        final Class<?> nsErrorClass = NSError.class;
        for (Class<? extends NSError> cls : classes) {
            if (cls != nsErrorClass && (cls.getModifiers() & ABSTRACT) == 0) {
                try {
                    Bro.bind(cls); // Global values need to be bound.
                    java.lang.reflect.Method m = cls.getMethod("getClassDomain", emptyArgs);
                    String domain = (String) m.invoke(null);
                    allNSErrorClasses.put(domain, cls);
                } catch (Throwable e) {
                    System.err.println("WARN: Failed to call getClassDomain() for " 
                            + "the NSError subclass " + cls.getName());
                }
            }
        }
    }
    
    
    /*<ptr>*/public static class NSErrorPtr extends Ptr<NSError, NSErrorPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(NSError.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected NSError(SkipInit skipInit) { super(skipInit); }
    public NSError(String domain, @MachineSizedSInt long code, NSErrorUserInfo dict) { super((SkipInit) null); initObject(init(domain, code, dict)); }
    /*</constructors>*/
    
    private static final Selector domain = Selector.register("domain");
    protected static String domain(long handle) {
        long h = ObjCRuntime.ptr_objc_msgSend(handle, domain.getHandle());
        NSString s = ObjCObject.toObjCObject(NSString.class, h, 0);
        return s.toString();
    }
    
    /*<properties>*/
    @Property(selector = "domain")
    public native String getDomain();
    @Property(selector = "code")
    public native @MachineSizedSInt long getCode();
    @Property(selector = "userInfo")
    public native NSErrorUserInfo getUserInfo();
    @Property(selector = "localizedDescription")
    public native String getLocalizedDescription();
    @Property(selector = "localizedFailureReason")
    public native String getLocalizedFailureReason();
    @Property(selector = "localizedRecoverySuggestion")
    public native String getLocalizedRecoverySuggestion();
    @Property(selector = "localizedRecoveryOptions")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getLocalizedRecoveryOptions();
    @Property(selector = "recoveryAttempter")
    public native NSErrorRecoveryAttempting getRecoveryAttempter();
    @Property(selector = "helpAnchor")
    public native String getHelpAnchor();
    /*</properties>*/
    /*<members>*//*</members>*/
    public NSURL getURL() {
        NSErrorUserInfo info = getUserInfo();
        if (info == null) return null;
        return info.getURL();
    }
    
    public NSErrorCode getErrorCode() {
        NSErrorCode code = null;
        try {
            code = NSCocoaErrorCode.valueOf(getCode());
        } catch (IllegalArgumentException e) {
            // ignore
        }
        return code;
    }
    /*<methods>*/
    @Method(selector = "initWithDomain:code:userInfo:")
    protected native @Pointer long init(String domain, @MachineSizedSInt long code, NSErrorUserInfo dict);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "setUserInfoValueProviderForDomain:provider:")
    public static native void setUserInfoValueProvider(String errorDomain, @Block Block2<NSError, String, NSObject> provider);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "userInfoValueProviderForDomain:")
    public static native @Block Block2<NSError, String, NSObject> getUserInfoValueProvider(NSError err, String userInfoKey, String errorDomain);
    /*</methods>*/
}
