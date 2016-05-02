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

/**
 * Deactivates the license key on the current machine
 * 
 * @author badlogic
 *
 */
@Mojo(name = "deactivate-license", requiresProject = false)
public class DeactivateLicenseMojo extends AbstractMojo {

    @Override
    public void execute() throws MojoExecutionException, MojoFailureException {
        try {
            Class clazz = ActivateLicenseMojo.class.getClassLoader().loadClass("com.bugvm.lm.LicenseManager");
            Method m = clazz.getMethod("main", String[].class);
            String[] args = { "deactivate" };
            m.invoke(null, new Object[] { args });
        } catch (Throwable e) {
            throw new MojoExecutionException("Couldn't deactivate license", e);
        }
    }
}
