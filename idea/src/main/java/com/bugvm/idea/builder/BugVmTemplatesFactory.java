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
package com.bugvm.idea.builder;

import com.intellij.ide.util.projectWizard.JavaModuleBuilder;
import com.intellij.ide.util.projectWizard.ModuleBuilder;
import com.intellij.ide.util.projectWizard.WizardContext;
import com.intellij.platform.ProjectTemplate;
import com.intellij.platform.ProjectTemplatesFactory;
import com.intellij.platform.templates.BuilderBasedTemplate;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import com.bugvm.idea.BugVmIcons;

import javax.swing.*;

/**
 * Returns a project template for every template known
 * by the templater. If a user selects one of the templates
 * it's build with the {@link BugVmModuleBuilder}
 *
 */
public class BugVmTemplatesFactory extends ProjectTemplatesFactory {
    @NotNull
    @Override
    public String[] getGroups() {
        return new String[] { "BugVM" };
    }

    @Override
    public int getGroupWeight(String group) {
        return JavaModuleBuilder.JAVA_MOBILE_WEIGHT;
    }

    @Override
    public String getParentGroup(String group) {
        return "Java";
    }

    @Override
    public Icon getGroupIcon(String group) {
        return BugVmIcons.BUGVM_SMALL;
    }

    @NotNull
    @Override
    public ProjectTemplate[] createTemplates(String group, WizardContext context) {
        return new ProjectTemplate[] {
                new BugVmProjectTemplate("BugVM Java iOS App", "A basic Java single view App", new BugVmModuleBuilder("java")),
                new BugVmProjectTemplate("BugVM Scala iOS App", "A basic Scala single view App", new BugVmModuleBuilder("scala")),
        };
    }

    private static class BugVmProjectTemplate extends BuilderBasedTemplate {
        private final String name;
        private final String description;

        public BugVmProjectTemplate(String name, String description, ModuleBuilder builder) {
            super(builder);
            this.name = name;
            this.description = description;
        }

        @NotNull
        @Override
        public String getName() {
            return name;
        }

        @Nullable
        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public Icon getIcon() {
            return BugVmIcons.BUGVM_SMALL;
        }
    }
}
