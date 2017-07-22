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
package com.bugvm.gradle.tasks;

/**
 * 
 */
public abstract class AbstractBugVMBuildTask extends AbstractBugVMTask {

    protected abstract boolean shouldArchive();
    
    @Override
    public void invoke() {
        try {
            com.bugvm.compiler.config.Config.Builder builder = configure(new com.bugvm.compiler.config.Config.Builder())
                    .skipInstall(false);

            if (extension.getArchs() != null) {
                java.util.List<com.bugvm.compiler.config.Arch> archs = new java.util.ArrayList<>();
                for (String s : extension.getArchs().trim().split(":")) {
                    archs.add(com.bugvm.compiler.config.Arch.valueOf(s));
                }
                builder.archs(archs);
            }

            com.bugvm.compiler.AppCompiler compiler = new com.bugvm.compiler.AppCompiler(builder.build());
            compiler.build();
            if (shouldArchive()) {
                compiler.archive();
            } else {
                compiler.install();
            }
        } catch (java.io.IOException e) {
            if (shouldArchive()) {
                throw new org.gradle.api.GradleException("Failed to create archive", e);
            } else {
                throw new org.gradle.api.GradleException("Failed to install", e);
            }
        }
    }
}