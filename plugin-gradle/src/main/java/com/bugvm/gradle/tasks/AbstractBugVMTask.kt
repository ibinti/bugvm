/*
 * Copyright (C) 2014 RoboVM AB.
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

/**
 * @author Junji Takakura
 */
abstract class AbstractBugVMTask : org.gradle.api.DefaultTask() {

    @JvmField var m_project: org.gradle.api.Project? = null
    @JvmField val extension: com.bugvm.gradle.BugVMPluginExtension
    val repositorySystem: org.sonatype.aether.RepositorySystem
    val repositorySystemSession: org.sonatype.aether.RepositorySystemSession
    val remoteRepositories: List<org.sonatype.aether.repository.RemoteRepository>
    var bugvmLogger: com.bugvm.compiler.log.Logger? = null

    init {
        m_project = project
        extension = project.extensions.getByName(com.bugvm.gradle.BugVMPluginExtension.NAME) as com.bugvm.gradle.BugVMPluginExtension
        repositorySystem = createRepositorySystem()
        repositorySystemSession = createRepositorySystemSession()
        remoteRepositories = createRemoteRepositories()
    }

    fun build(os: com.bugvm.compiler.config.OS, arch: com.bugvm.compiler.config.Arch, targetType: String): com.bugvm.compiler.AppCompiler {
        logger.info("Building BugVM app for: $os ($arch)")

        val builder: com.bugvm.compiler.config.Config.Builder
        try {
            builder = com.bugvm.compiler.config.Config.Builder()
        } catch (e: java.io.IOException) {
            throw org.gradle.api.GradleException(e.message, e)
        }

        configure(builder).os(os).arch(arch).targetType(targetType)

        // execute the BugVM build
        val config: com.bugvm.compiler.config.Config

        try {
            logger.info("Compiling BugVM app, this could take a while, especially the first time round")
            config = builder.build()
            val compiler = com.bugvm.compiler.AppCompiler(config)
            compiler.build()
            logger.info("Compile BugVM app completed.")
            return compiler
        } catch (e: java.io.IOException) {
            throw org.gradle.api.GradleException("Error building BugVM executable for app", e)
        }

    }

    protected fun configure(builder: com.bugvm.compiler.config.Config.Builder): com.bugvm.compiler.config.Config.Builder {
        builder.logger(getBugVMLogger())

        if (extension.propertiesFile != null) {
            val propertiesFile = java.io.File(extension.propertiesFile)

            if (!propertiesFile.exists()) {
                throw org.gradle.api.GradleException("Invalid 'propertiesFile' specified for BugVM compile: " + propertiesFile)
            }
            try {
                logger.debug(
                        "Including properties file in BugVM compiler config: " + propertiesFile.absolutePath)
                builder.addProperties(propertiesFile)
            } catch (e: java.io.IOException) {
                throw org.gradle.api.GradleException("Failed to add properties file to BugVM config: " + propertiesFile)
            }

        } else {
            try {
                builder.readProjectProperties(project.projectDir, false)
            } catch (e: java.io.IOException) {
                throw org.gradle.api.GradleException(
                        "Failed to read BugVM bugvmProject properties file(s) in " + project.projectDir.absolutePath, e)
            }

        }

        if (extension.configFile != null) {
            val configFile = java.io.File(extension.configFile)

            if (!configFile.exists()) {
                throw org.gradle.api.GradleException("Invalid 'configFile' specified for BugVM compile: " + configFile)
            }
            try {
                logger.debug("Loading config file for BugVM compiler: " + configFile.absolutePath)
                builder.read(configFile)
            } catch (e: Exception) {
                throw org.gradle.api.GradleException("Failed to read BugVM config file: " + configFile)
            }

        } else {
            try {
                builder.readProjectConfig(project.projectDir, false)
            } catch (e: Exception) {
                throw org.gradle.api.GradleException(
                        "Failed to read bugvmProject BugVM config file in " + project.projectDir.absolutePath, e)
            }

        }

        var installDir: java.io.File? = null
        if (extension.installDir != null) {
            installDir = java.io.File(extension.installDir)
        } else {
            installDir = java.io.File(project.buildDir, "bugvm")
        }
        var cacheDir: java.io.File? = null
        if (extension.cacheDir != null) {
            cacheDir = java.io.File(extension.cacheDir!!)
        } else {
            cacheDir = com.bugvm.compiler.config.Config.getDefaultCacheDir()
        }
        val temporaryDirectory = java.io.File(project.buildDir, "bugvm.tmp")
        try {
            org.apache.commons.io.FileUtils.deleteDirectory(temporaryDirectory)
        } catch (e: java.io.IOException) {
            throw org.gradle.api.GradleException("Failed to clean output dir " + temporaryDirectory, e)
        }

        temporaryDirectory.mkdirs()

        builder.home(com.bugvm.compiler.config.Config.Home(unpack()))
                .tmpDir(temporaryDirectory)
                .skipInstall(true)
                .installDir(installDir)
                .cacheDir(cacheDir)

        if (project.hasProperty("mainClassName")) {
            builder.mainClass(project.property("mainClassName") as String)
        }

        if (extension.isDebug) {
            builder.debug(true)
            if (extension.debugPort != -1) {
                builder.addPluginArgument("debug:jdwpport=" + extension.debugPort)
            }
        }

        if (extension.isIosSkipSigning) {
            builder.iosSkipSigning(true)
        } else {
            if (extension.iosSignIdentity != null) {
                val iosSignIdentity = extension.iosSignIdentity

                logger.debug("Using explicit iOS Signing identity: " + iosSignIdentity)
                builder.iosSignIdentity(com.bugvm.compiler.target.ios.SigningIdentity.find(com.bugvm.compiler.target.ios.SigningIdentity.list(), iosSignIdentity))
            }

            if (extension.iosProvisioningProfile != null) {
                val iosProvisioningProfile = extension.iosProvisioningProfile

                logger.debug("Using explicit iOS provisioning profile: " + iosProvisioningProfile)
                builder.iosProvisioningProfile(com.bugvm.compiler.target.ios.ProvisioningProfile.find(com.bugvm.compiler.target.ios.ProvisioningProfile.list(),
                        iosProvisioningProfile))
            }
        }

        builder.clearClasspathEntries()

        // configure the runtime classpath
        val classpathEntries = project.configurations.getByName("runtime").files
        classpathEntries.add(java.io.File(project.buildDir, "classes/main"))

        if (project.hasProperty("output.classesDir")) {
            classpathEntries.add(project.property("output.classesDir") as java.io.File)
        }

        for (classpathEntry in classpathEntries) {
            if (logger.isDebugEnabled) {
                logger.debug("Including classpath element for BugVM app: " + classpathEntry.absolutePath)
            }

            if (classpathEntry.name.startsWith("bugvm-rt")) {
                builder.addBootClasspathEntry(classpathEntry)
            } else {
                builder.addClasspathEntry(classpathEntry)
            }
        }

        return builder
    }

    @org.gradle.api.tasks.TaskAction
    abstract operator fun invoke()

    @Throws(org.gradle.api.GradleException::class)
    protected fun unpack(): java.io.File {
        val artifact = resolveArtifact("com.bugvm:bugvm-dist:tgz:" + com.bugvm.gradle.BugVMPlugin.getBugVMVersion())
        val distTarFile = artifact.file
        val unpackedDirectory = java.io.File(distTarFile.parent, "unpacked")
        val unpackedDistDirectory = java.io.File(unpackedDirectory, "bugvm-" + com.bugvm.gradle.BugVMPlugin.getBugVMVersion())

        if (unpackedDirectory.exists() && artifact.isSnapshot) {
            ant.invokeMethod("delete", object : HashMap<String, Any>() {
                init {
                    put("dir", unpackedDirectory.absolutePath)
                }
            })
        }

        if (unpackedDirectory.exists()) {
            logger.debug("Archive '$distTarFile' was already unpacked in: $unpackedDirectory")
        } else {
            logger.info("Extracting '$distTarFile' to: $unpackedDirectory")

            if (!unpackedDirectory.mkdirs()) {
                throw org.gradle.api.GradleException("Unable to create base directory to unpack into: " + unpackedDirectory)
            }

            try {
                extractTarGz(distTarFile, unpackedDirectory)
            } catch (e: java.io.IOException) {
                throw org.gradle.api.GradleException("Couldn't extract distribution tgz", e)
            }

            if (!unpackedDistDirectory.exists()) {
                throw org.gradle.api.GradleException("Unable to unpack archive")
            }

            logger.debug("Archive '$distTarFile' unpacked to: $unpackedDirectory")
        }

        ant.invokeMethod("chmod", object : HashMap<String, Any>() {
            init {
                put("dir", java.io.File(unpackedDistDirectory, "bin").absoluteFile)
                put("perm", "+x")
                put("includes", "*")
            }
        })

        return unpackedDistDirectory
    }

    @Throws(org.gradle.api.GradleException::class)
    protected fun resolveArtifact(artifactLocator: String): org.sonatype.aether.artifact.Artifact {
        val request = org.sonatype.aether.resolution.ArtifactRequest()
        val artifact = org.sonatype.aether.util.artifact.DefaultArtifact(artifactLocator)
        request.artifact = artifact
        request.repositories = remoteRepositories

        logger.debug("Resolving artifact $artifact from $remoteRepositories")

        val result: org.sonatype.aether.resolution.ArtifactResult

        try {
            result = repositorySystem.resolveArtifact(repositorySystemSession, request)
        } catch (e: org.sonatype.aether.resolution.ArtifactResolutionException) {
            throw org.gradle.api.GradleException(e.message, e)
        }

        logger.debug(
                "Resolved artifact " + artifact + " to " + result.artifact.file + " from "
                        + result.repository)

        return result.artifact
    }

    protected fun getBugVMLogger(): com.bugvm.compiler.log.Logger {
        if (bugvmLogger == null) {
            bugvmLogger = object : com.bugvm.compiler.log.Logger {
                override fun debug(s: String, vararg objects: Any) {
                    logger.debug(String.format(s, *objects))
                }

                override fun info(s: String, vararg objects: Any) {
                    logger.info(String.format(s, *objects))
                }

                override fun warn(s: String, vararg objects: Any) {
                    logger.warn(String.format(s, *objects))
                }

                override fun error(s: String, vararg objects: Any) {
                    logger.error(String.format(s, *objects))
                }
            }
        }

        return bugvmLogger!!
    }

    private fun createRepositorySystem(): org.sonatype.aether.RepositorySystem {
        val locator = org.apache.maven.repository.internal.MavenServiceLocator()
        locator.addService(org.sonatype.aether.spi.connector.RepositoryConnectorFactory::class.java, org.sonatype.aether.connector.wagon.WagonRepositoryConnectorFactory::class.java)
        locator.setService(org.sonatype.aether.connector.wagon.WagonProvider::class.java, ManualWagonProvider::class.java)

        return locator.getService(org.sonatype.aether.RepositorySystem::class.java)
    }

    private fun createRepositorySystemSession(): org.sonatype.aether.RepositorySystemSession {
        val localRepository = org.sonatype.aether.repository.LocalRepository(System.getProperty("user.home") + "/.m2/repository")
        val session = org.apache.maven.repository.internal.MavenRepositorySystemSession()
        session.localRepositoryManager = repositorySystem.newLocalRepositoryManager(localRepository)

        return session
    }

    private fun createRemoteRepositories(): List<org.sonatype.aether.repository.RemoteRepository> {
        val repositories = ArrayList<org.sonatype.aether.repository.RemoteRepository>()
        repositories.add(org.sonatype.aether.repository.RemoteRepository("maven-central", "default", "http://repo1.maven.org/maven2/"))
        repositories.add(org.sonatype.aether.repository.RemoteRepository("oss.sonatype.org-snapshots", "default",
                "https://oss.sonatype.org/content/repositories/snapshots/"))

        return repositories
    }

    @Throws(java.io.IOException::class)
    private fun extractTarGz(archive: java.io.File, destDir: java.io.File) {
        var `in`: org.apache.commons.compress.archivers.tar.TarArchiveInputStream? = null
        try {
            `in` = org.apache.commons.compress.archivers.tar.TarArchiveInputStream(java.util.zip.GZIPInputStream(java.io.FileInputStream(archive)))
            var entry: org.apache.commons.compress.archivers.ArchiveEntry = `in`.nextEntry
            while (entry != null) {
                val f = java.io.File(destDir, entry!!.name)
                if (entry.isDirectory) {
                    f.mkdirs()
                } else {
                    f.parentFile.mkdirs()
                    var out: java.io.OutputStream? = null
                    try {
                        out = java.io.FileOutputStream(f)
                        org.apache.commons.io.IOUtils.copy(`in`, out)
                    } finally {
                        org.apache.commons.io.IOUtils.closeQuietly(out)
                    }
                }
                f.setLastModified(entry.lastModifiedDate.time)
                if (entry is org.apache.commons.compress.archivers.tar.TarArchiveEntry) {
                    val mode = entry.mode
                    if (mode and 64 > 0) {
                        // Preserve execute permissions
                        f.setExecutable(true, mode and 1 == 0)
                    }
                }
                entry = `in`.nextEntry
            }
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(`in`)
        }
    }

    class ManualWagonProvider : org.sonatype.aether.connector.wagon.WagonProvider {

        @Throws(Exception::class)
        override fun lookup(roleHint: String): org.apache.maven.wagon.Wagon? {
            if ("http" == roleHint || "https" == roleHint) {
                return org.apache.maven.wagon.providers.http.HttpWagon()
            }

            return null
        }

        override fun release(wagon: org.apache.maven.wagon.Wagon) {
            // noop
        }
    }
}