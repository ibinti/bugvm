/*
 * Copyright (C) 2015 RoboVM AB.
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
package com.bugvm.maven.plugin;

import java.lang.reflect.Method;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugin.MojoExecutionException;
import org.apache.maven.plugin.MojoFailureException;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

/**
 * Activates the license key specified via -Dbugvm.licenseKey
 * 
 * @author badlogic
 *
 */
@Mojo(name = "activate-license", requiresProject = false)
public class ActivateLicenseMojo extends AbstractMojo {
    /**
     * The license key to activate
     */
    @Parameter(property = "bugvm.licenseKey")
    protected String licenseKey;

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        if (licenseKey == null) {
            throw new MojoFailureException("Provide a license key to activate via -Dbugvm.licenseKey");
        }

        try {
            Class clazz = ActivateLicenseMojo.class.getClassLoader().loadClass("com.bugvm.lm.LicenseManager");
            Method m = clazz.getMethod("main", String[].class);
            String[] args = { "activate", licenseKey };
            m.invoke(null, new Object[] { args });            
        } catch (Throwable e) {
            throw new MojoExecutionException("Couldn't activate license", e);
        }
    }
}
