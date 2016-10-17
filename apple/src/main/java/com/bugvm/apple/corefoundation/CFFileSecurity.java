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
package com.bugvm.apple.corefoundation;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreservices.*;
import com.bugvm.apple.coremedia.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.coretext.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("CoreFoundation")/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFFileSecurity/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/public static class CFFileSecurityPtr extends Ptr<CFFileSecurity, CFFileSecurityPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(CFFileSecurity.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    protected CFFileSecurity() {}
    /*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static CFFileSecurity create() {
        return create(null);
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public static CFFileSecurity createCopy(CFFileSecurity fileSec) {
        return createCopy(null, fileSec);
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public CFUUID getOwnerUUID() {
        CFUUID.CFUUIDPtr ptr = new CFUUID.CFUUIDPtr();
        getOwnerUUID(ptr);
        return ptr.get();
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public CFUUID getGroupUUID() {
        CFUUID.CFUUIDPtr ptr = new CFUUID.CFUUIDPtr();
        getGroupUUID(ptr);
        return ptr.get();
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public int getOwner() {
        IntPtr ptr = new IntPtr();
        getOwner(ptr);
        return ptr.get();
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public int getGroup() {
        IntPtr ptr = new IntPtr();
        getGroup(ptr);
        return ptr.get();
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public short getMode() {
        ShortPtr ptr = new ShortPtr();
        getMode(ptr);
        return ptr.get();
    }
    /*<methods>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CFFileSecurityGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CFFileSecurityCreate", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFFileSecurity create(CFAllocator allocator);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CFFileSecurityCreateCopy", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFFileSecurity createCopy(CFAllocator allocator, CFFileSecurity fileSec);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CFFileSecurityCopyOwnerUUID", optional=true)
    private native boolean getOwnerUUID(CFUUID.CFUUIDPtr ownerUUID);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CFFileSecuritySetOwnerUUID", optional=true)
    public native boolean setOwnerUUID(CFUUID ownerUUID);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CFFileSecurityCopyGroupUUID", optional=true)
    private native boolean getGroupUUID(CFUUID.CFUUIDPtr groupUUID);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CFFileSecuritySetGroupUUID", optional=true)
    public native boolean setGroupUUID(CFUUID groupUUID);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CFFileSecurityGetOwner", optional=true)
    private native boolean getOwner(IntPtr owner);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CFFileSecuritySetOwner", optional=true)
    public native boolean setOwner(int owner);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CFFileSecurityGetGroup", optional=true)
    private native boolean getGroup(IntPtr group);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CFFileSecuritySetGroup", optional=true)
    public native boolean setGroup(int group);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CFFileSecurityGetMode", optional=true)
    private native boolean getMode(ShortPtr mode);
    /**
     * @since Available in iOS 5.0 and later.
     */
    @Bridge(symbol="CFFileSecuritySetMode", optional=true)
    public native boolean setMode(short mode);
    /**
     * @since Available in iOS 6.0 and later.
     */
    @Bridge(symbol="CFFileSecurityClearProperties", optional=true)
    public native boolean clearProperties(CFFileSecurityClearOptions clearPropertyMask);
    /*</methods>*/
}
