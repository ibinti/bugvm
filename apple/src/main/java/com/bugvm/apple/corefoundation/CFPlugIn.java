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
/*<visibility>*/public/*</visibility>*/ class /*<name>*/CFPlugIn/*</name>*/ 
    extends /*<extends>*/CFType/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    /*<ptr>*/
    /*</ptr>*/
    /*<bind>*/static { Bro.bind(CFPlugIn.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*//*</constructors>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    public static CFPlugIn create(CFURL plugInURL) {
        return create(null, plugInURL);
    }
    /*<methods>*/
    @Bridge(symbol="CFPlugInGetTypeID", optional=true)
    public static native @MachineSizedUInt long getClassTypeID();
    @Bridge(symbol="CFPlugInCreate", optional=true)
    public static native @com.bugvm.rt.bro.annotation.Marshaler(CFType.NoRetainMarshaler.class) CFPlugIn create(CFAllocator allocator, CFURL plugInURL);
    @Bridge(symbol="CFPlugInGetBundle", optional=true)
    public native CFBundle getBundle();
    @Bridge(symbol="CFPlugInSetLoadOnDemand", optional=true)
    public native void setLoadOnDemand(boolean flag);
    @Bridge(symbol="CFPlugInIsLoadOnDemand", optional=true)
    public native boolean isLoadingOnDemand();
    @Bridge(symbol="CFPlugInFindFactoriesForPlugInType", optional=true)
    public static native CFArray findFactoriesForPlugInType(CFUUID typeUUID);
    @Bridge(symbol="CFPlugInFindFactoriesForPlugInTypeInPlugIn", optional=true)
    public static native CFArray findFactoriesForPlugInTypeInPlugIn(CFUUID typeUUID, CFPlugIn plugIn);
    @Bridge(symbol="CFPlugInRegisterFactoryFunction", optional=true)
    public static native boolean registerFactoryFunction(CFUUID factoryUUID, FunctionPtr func);
    @Bridge(symbol="CFPlugInRegisterFactoryFunctionByName", optional=true)
    public static native boolean registerFactoryFunctionByName(CFUUID factoryUUID, CFPlugIn plugIn, String functionName);
    @Bridge(symbol="CFPlugInUnregisterFactory", optional=true)
    public static native boolean unregisterFactory(CFUUID factoryUUID);
    @Bridge(symbol="CFPlugInRegisterPlugInType", optional=true)
    public static native boolean registerPlugInType(CFUUID factoryUUID, CFUUID typeUUID);
    @Bridge(symbol="CFPlugInUnregisterPlugInType", optional=true)
    public static native boolean unregisterPlugInType(CFUUID factoryUUID, CFUUID typeUUID);
    @Bridge(symbol="CFPlugInAddInstanceForFactory", optional=true)
    public static native void addInstanceForFactory(CFUUID factoryID);
    @Bridge(symbol="CFPlugInRemoveInstanceForFactory", optional=true)
    public static native void removeInstanceForFactory(CFUUID factoryID);
    /*</methods>*/
}
