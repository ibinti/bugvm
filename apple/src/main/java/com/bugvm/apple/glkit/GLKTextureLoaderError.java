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
package com.bugvm.apple.glkit;

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
import com.bugvm.apple.corefoundation.*;
import com.bugvm.apple.coregraphics.*;
import com.bugvm.apple.opengles.*;
import com.bugvm.apple.uikit.*;
import com.bugvm.apple.dispatch.*;
/*</imports>*/

/*<javadoc>*/
/*</javadoc>*/
/*<annotations>*/@Library("GLKit") @StronglyLinked/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/GLKTextureLoaderError/*</name>*/ 
    extends /*<extends>*/NSError/*</extends>*/ 
    /*<implements>*//*</implements>*/ {

    protected GLKTextureLoaderError (SkipInit skipInit) {
        super(skipInit);
    }
    
    /*<ptr>*/public static class GLKTextureLoaderErrorPtr extends Ptr<GLKTextureLoaderError, GLKTextureLoaderErrorPtr> {}/*</ptr>*/
    /*<bind>*/static { Bro.bind(GLKTextureLoaderError.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<properties>*//*</properties>*/
    /*<members>*//*</members>*/
    private NSErrorUserInfo userInfo;
    
    /* Convenience methods */
    private NSErrorUserInfo getCachedUserInfo() {
        if (userInfo == null) {
            userInfo = getUserInfo();
        }
        return userInfo;
    }
    
    @Override
    public GLKTextureLoaderErrorCode getErrorCode () {
        GLKTextureLoaderErrorCode code = null;
        try {
            code = GLKTextureLoaderErrorCode.valueOf(getCode());
        } catch (IllegalArgumentException e) {
            // ignore
        }
        return code;
    }
    
    /* Convenience methods */
    /**
     * @since Available in iOS 5.0 and later.
     */
    public String getError() {
        if (getCachedUserInfo().has(GLKErrorUserInfoKey.Error)) {
            NSString val = (NSString) getCachedUserInfo().get(GLKErrorUserInfoKey.Error);
            return val.toString();
        }
        return null;
    }
    /**
     * @since Available in iOS 5.0 and later.
     */
    public long getGLError() {
        if (getCachedUserInfo().has(GLKErrorUserInfoKey.GLError)) {
            NSNumber val = (NSNumber) getCachedUserInfo().get(GLKErrorUserInfoKey.GLError);
            return val.longValue();
        }
        return 0;
    }
    /*<methods>*/
    /**
     * @since Available in iOS 5.0 and later.
     */
    @GlobalValue(symbol="GLKTextureLoaderErrorDomain", optional=true)
    public static native String getClassDomain();
    /*</methods>*/
}
