/*
 * Copyright (C) 2015 RoboVM AB
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
package com.bugvm.idea.components;

import com.bugvm.idea.components.setupwizard.*;
import com.bugvm.idea.sdk.BugVmSdkType;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.application.ex.ApplicationManagerEx;
import com.intellij.openapi.components.ApplicationComponent;
import com.intellij.openapi.components.StoragePathMacros;
import com.intellij.openapi.module.Module;
import com.intellij.openapi.module.ModuleManager;
import com.intellij.openapi.projectRoots.Sdk;
import com.intellij.openapi.roots.ModuleRootManager;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.openapi.vfs.VirtualFileAdapter;
import com.intellij.openapi.vfs.VirtualFileEvent;
import com.intellij.openapi.vfs.VirtualFileManager;
import org.jetbrains.annotations.NotNull;
import com.bugvm.compiler.config.OS;
import com.bugvm.compiler.util.ToolchainUtil;
import com.bugvm.idea.BugVmPlugin;

/**
 * Call on app startup, responsible for extracting/updating the BugVM SDK and
 * setting up the SDK so its available in IDEA.
 */
public class BugVmApplicationComponent implements ApplicationComponent {

    public static final String BUGVM_HAS_SHOWN_NO_XCODE_WIZARD = "bugvm.hasShownNoXcodeWizard";

    @Override
    public void initComponent() {
        displaySetupWizard();
        BugVmPlugin.extractSdk();
    }

    private void displaySetupWizard() {

        // make sure a JDK is configured
        Sdk jdk = BugVmSdkType.findBestJdk();
        if (jdk == null) {
            new JdkSetupDialog().show();
        }

        // make sure Xcode is installed
        // If we are on a Mac, otherwise
        // inform the user that they
        // won't be able to compile for
        // iOS
        if (System.getProperty("os.name").contains("Mac")) {
            try {
                ToolchainUtil.findXcodePath();
            } catch (Throwable e) {
                new XcodeSetupDialog().show();
            }
        } else {
            if(!PropertiesComponent.getInstance().getBoolean(BUGVM_HAS_SHOWN_NO_XCODE_WIZARD, false)) {
                new NoXcodeSetupDialog().show();
                PropertiesComponent.getInstance().setValue(BUGVM_HAS_SHOWN_NO_XCODE_WIZARD, "true");
            }
        }

    }

    @Override
    public void disposeComponent() {}

    @NotNull
    @Override
    public String getComponentName() {
        return "BugVmApplicationComponent";
    }
}
