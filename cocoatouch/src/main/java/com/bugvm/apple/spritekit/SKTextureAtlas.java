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
package com.bugvm.apple.spritekit;

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
import com.bugvm.apple.dispatch.*;
import com.bugvm.apple.coreimage.*;
import com.bugvm.apple.avfoundation.*;
import com.bugvm.apple.glkit.*;
import com.bugvm.apple.scenekit.*;
import com.bugvm.apple.gameplaykit.*;
/*</imports>*/

/*<javadoc>*/

/*</javadoc>*/
/*<annotations>*/@Library("SpriteKit") @NativeClass/*</annotations>*/
/*<visibility>*/public/*</visibility>*/ class /*<name>*/SKTextureAtlas/*</name>*/ 
    extends /*<extends>*/NSObject/*</extends>*/ 
    /*<implements>*/implements NSCoding/*</implements>*/ {

    /*<ptr>*/public static class SKTextureAtlasPtr extends Ptr<SKTextureAtlas, SKTextureAtlasPtr> {}/*</ptr>*/
    /*<bind>*/static { ObjCRuntime.bind(SKTextureAtlas.class); }/*</bind>*/
    /*<constants>*//*</constants>*/
    /*<constructors>*/
    public SKTextureAtlas() {}
    protected SKTextureAtlas(SkipInit skipInit) { super(skipInit); }
    public SKTextureAtlas(String name) { super(create(name)); retain(getHandle()); }
    public SKTextureAtlas(NSCoder aDecoder) { super((SkipInit) null); initObject(init(aDecoder)); }
    /*</constructors>*/
    /**
     * Constructs a new texture atlas object from the specified texture files.
     * @param properties The keys of this map represent the texture names. 
     * The associated values can be of type String, NSURL or UIImage.
     * @return
     * @since Available in iOS 8.0 and later.
     */
    public SKTextureAtlas(Map<String, ?> textures) {
        super(create(textures));
        retain(getHandle());
    }
    
    private static long create(Map<String, ?> textures) {
        NSDictionary<NSString, ?> properties = new NSMutableDictionary<>();
        for (Map.Entry<String, ?> entry : textures.entrySet()) {
            NSString key = new NSString(entry.getKey());
            NSObject value = null;
            if (entry.getValue() instanceof String) {
                value = new NSString((String)entry.getValue());
            } else if (entry.getValue() instanceof NSURL || entry.getValue() instanceof UIImage || entry.getValue() instanceof NSString) {
                value = (NSObject)entry.getValue();
            } else {
                throw new IllegalArgumentException("Only String, NSURL, UIImage or NSString are allowed!");
            }
            properties.put(key, value);
        }
        return create(properties);
    }
    /*<properties>*/
    @Property(selector = "textureNames")
    public native @com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> getTextureNames();
    /*</properties>*/
    /*<members>*//*</members>*/
    /*<methods>*/
    @Method(selector = "textureNamed:")
    public native SKTexture getTexture(String name);
    @Method(selector = "preloadWithCompletionHandler:")
    public native void preload(@Block Runnable completionHandler);
    @Method(selector = "atlasNamed:")
    protected static native @Pointer long create(String name);
    /**
     * @since Available in iOS 8.0 and later.
     */
    @Method(selector = "atlasWithDictionary:")
    protected static native @Pointer long create(NSDictionary<?, ?> properties);
    @Method(selector = "preloadTextureAtlases:withCompletionHandler:")
    public static native void preloadTextureAtlases(NSArray<SKTextureAtlas> textureAtlases, @Block Runnable completionHandler);
    /**
     * @since Available in iOS 9.0 and later.
     */
    @Method(selector = "preloadTextureAtlasesNamed:withCompletionHandler:")
    public static native void preloadTextureAtlases(@com.bugvm.rt.bro.annotation.Marshaler(NSArray.AsStringListMarshaler.class) List<String> atlasNames, @Block VoidBlock2<NSError, NSArray<SKTextureAtlas>> completionHandler);
    @Method(selector = "encodeWithCoder:")
    public native void encode(NSCoder coder);
    @Method(selector = "initWithCoder:")
    protected native @Pointer long init(NSCoder aDecoder);
    /*</methods>*/
}
