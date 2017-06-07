/*
 * Copyright (C) 2012 RoboVM AB
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/gpl-2.0.html>.
 */
package com.bugvm.compiler;

import com.bugvm.compiler.config.Config;

import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

import static com.bugvm.compiler.config.Config.getImplementationVersion;

public class Version {

    /**
     * Returns the version number of the compiler by reading the MANIFEST.MF
     * file.
     * 
     * @return the version.
     */
    public static String getVersion() {

        Class clazz = Version.class;
        String className = clazz.getSimpleName() + ".class";
        String classPath = clazz.getResource(className).toString();
        String manifestPath = classPath.substring(0, classPath.lastIndexOf("!") + 1) +
                "/META-INF/MANIFEST.MF";
        Manifest manifest = null;
        try {
            manifest = new Manifest(new URL(manifestPath).openStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        Attributes attr = manifest.getMainAttributes();
        return attr.getValue("Implementation-Version");

    }
    
    /**
     * Converts a version string on the form x.y.z into an integer which can
     * be compared to other versions converted into integers.
     */
    static long toLong(String v) {
        String buildPart = "1";
        long buildType = 700;
        if (v.endsWith("-SNAPSHOT")) {
            buildPart = "";
            v = v.substring(0, v.indexOf("-SNAPSHOT"));
            buildType = 0;
        } else if (v.contains("-alpha-")) {
            buildPart = v.substring(v.lastIndexOf('-') + 1);
            v = v.substring(0, v.indexOf("-alpha-"));
            buildType = 100;
        } else if (v.contains("-beta-")) {
            buildPart = v.substring(v.lastIndexOf('-') + 1);
            v = v.substring(0, v.indexOf("-beta-"));
            buildType = 300;
        } else if (v.contains("-rc-")) {
            buildPart = v.substring(v.lastIndexOf('-') + 1);
            v = v.substring(0, v.indexOf("-rc-"));
            buildType = 500;
        }
        
        String[] parts = v.split("\\.");
        if (parts.length > 3) {
            throw new IllegalArgumentException("Illegal version number: " + v);
        }
        
        long major = parts.length > 0 ? Long.parseLong(parts[0]) : 0;
        long minor = parts.length > 1 ? Long.parseLong(parts[1]) : 0;
        long rev = parts.length > 2 ? Long.parseLong(parts[2]) : 0;
        long build = buildPart.isEmpty() ? 0 : Long.parseLong(buildPart);
        long result = (((major * 1000 + minor) * 1000 + rev) * 1000) + build + buildType;
        return result;
    }
    
    /**
     * Returns <code>true</code> if this version is less than the specified
     * version number.
     */
    public static boolean isOlderThan(String otherVersion) {
        return toLong(getVersion()) < toLong(otherVersion);
    }
}
