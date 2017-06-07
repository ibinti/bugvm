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
package com.bugvm.gradle.tasks

abstract class AbstractBugVMBuildTask : AbstractBugVMTask() {

    protected abstract fun shouldArchive(): Boolean

    override fun invoke() {
        try {
            val builder = configure(com.bugvm.compiler.config.Config.Builder())
                    .skipInstall(false)

            if (extension!!.archs != null) {
                val archs = java.util.ArrayList<com.bugvm.compiler.config.Arch>()
                for (s in extension!!.archs!!.trim { it <= ' ' }.split(":".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()) {
                    archs.add(com.bugvm.compiler.config.Arch.valueOf(s))
                }
                builder.archs(archs)
            }

            val compiler = com.bugvm.compiler.AppCompiler(builder.build())
            compiler.build()
            if (shouldArchive()) {
                compiler.archive()
            } else {
                compiler.install()
            }
        } catch (e: java.io.IOException) {
            if (shouldArchive()) {
                throw org.gradle.api.GradleException("Failed to create archive", e)
            } else {
                throw org.gradle.api.GradleException("Failed to install", e)
            }
        }

    }
}