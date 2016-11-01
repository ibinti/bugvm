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
package com.bugvm.idea.running;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import org.jetbrains.annotations.NotNull;
import com.bugvm.idea.BugVmIcons;

import javax.swing.*;

public class BugVmIOSConfigurationType implements ConfigurationType {
    @Override
    public String getDisplayName() {
        return "BugVM iOS";
    }

    @Override
    public String getConfigurationTypeDescription() {
        return "A run configuration to test your app on the iOS simulator or an iOS device";
    }

    @Override
    public Icon getIcon() {
        return BugVmIcons.BUGVM_SMALL;
    }

    @NotNull
    @Override
    public String getId() {
        return "com.bugvm.idea.running.BugVmIOSConfigurationType";
    }

    @Override
    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[] {
                new BugVmConfigurationFactory(this)
        };
    }
}
