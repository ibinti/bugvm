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

import com.bugvm.compiler.AppCompiler
import com.bugvm.compiler.config.Arch
import com.bugvm.compiler.config.Config
import com.bugvm.compiler.config.OS
import com.bugvm.compiler.log.Logger
import com.bugvm.compiler.target.ios.ProvisioningProfile
import com.bugvm.compiler.target.ios.SigningIdentity
import com.bugvm.gradle.BugVMPlugin
import com.bugvm.gradle.BugVMPluginExtension
import org.apache.commons.compress.archivers.ArchiveEntry
import org.apache.commons.compress.archivers.tar.TarArchiveEntry
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream
import org.apache.commons.io.FileUtils
import org.apache.commons.io.IOUtils
import org.apache.maven.repository.internal.MavenRepositorySystemSession
import org.apache.maven.repository.internal.MavenServiceLocator
import org.apache.maven.wagon.Wagon
import org.apache.maven.wagon.providers.http.HttpWagon
import org.gradle.api.DefaultTask
import org.gradle.api.GradleException
import org.gradle.api.Project
import org.gradle.api.tasks.TaskAction
import org.sonatype.aether.RepositorySystem
import org.sonatype.aether.RepositorySystemSession
import org.sonatype.aether.artifact.Artifact
import org.sonatype.aether.connector.wagon.WagonProvider
import org.sonatype.aether.connector.wagon.WagonRepositoryConnectorFactory
import org.sonatype.aether.repository.LocalRepository
import org.sonatype.aether.repository.RemoteRepository
import org.sonatype.aether.resolution.ArtifactRequest
import org.sonatype.aether.resolution.ArtifactResolutionException
import org.sonatype.aether.resolution.ArtifactResult
import org.sonatype.aether.spi.connector.RepositoryConnectorFactory
import org.sonatype.aether.util.artifact.DefaultArtifact
import java.io.*
import java.util.*
import java.util.zip.GZIPInputStream

/**

 * @author Junji Takakura
 */
abstract class AbstractBugVMTask : DefaultTask() {

    protected val bugvmProject: Project
    protected val extension: BugVMPluginExtension
    protected val repositorySystem: RepositorySystem
    protected val repositorySystemSession: RepositorySystemSession
    protected val remoteRepositories: List<RemoteRepository>
    protected var bugVMLogger: Logger? = null

    init {
        bugvmProject = getProject()
        extension = bugvmProject.extensions.getByName(BugVMPluginExtension.NAME) as BugVMPluginExtension
        repositorySystem = createRepositorySystem()
        repositorySystemSession = createRepositorySystemSession()
        remoteRepositories = createRemoteRepositories()
    }

    fun build(os: OS, arch: Arch, targetType: String): AppCompiler {
        logger.info("Building BugVM app for: $os ($arch)")

        val builder: Config.Builder
        try {
            builder = Config.Builder()
        } catch (e: IOException) {
            throw GradleException(e.message, e)
        }

        configure(builder).os(os).arch(arch).targetType(targetType)

        // execute the BugVM build
        val config: Config

        try {
            logger.info("Compiling BugVM app, this could take a while, especially the first time round")
            config = builder.build()
            val compiler = AppCompiler(config)
            compiler.build()
            logger.info("Compile BugVM app completed.")
            return compiler
        } catch (e: IOException) {
            throw GradleException("Error building BugVM executable for app", e)
        }

    }

    protected fun configure(builder: Config.Builder): Config.Builder {
        builder.logger(GetBugVMLogger())

        if (extension.propertiesFile != null) {
            val propertiesFile = File(extension.propertiesFile)

            if (!propertiesFile.exists()) {
                throw GradleException("Invalid 'propertiesFile' specified for BugVM compile: " + propertiesFile)
            }
            try {
                logger.debug(
                        "Including properties file in BugVM compiler config: " + propertiesFile.absolutePath)
                builder.addProperties(propertiesFile)
            } catch (e: IOException) {
                throw GradleException("Failed to add properties file to BugVM config: " + propertiesFile)
            }

        } else {
            try {
                builder.readProjectProperties(bugvmProject.projectDir, false)
            } catch (e: IOException) {
                throw GradleException(
                        "Failed to read BugVM bugvmProject properties file(s) in " + bugvmProject.projectDir.absolutePath, e)
            }

        }

        if (extension.configFile != null) {
            val configFile = File(extension.configFile)

            if (!configFile.exists()) {
                throw GradleException("Invalid 'configFile' specified for BugVM compile: " + configFile)
            }
            try {
                logger.debug("Loading config file for BugVM compiler: " + configFile.absolutePath)
                builder.read(configFile)
            } catch (e: Exception) {
                throw GradleException("Failed to read BugVM config file: " + configFile)
            }

        } else {
            try {
                builder.readProjectConfig(bugvmProject.projectDir, false)
            } catch (e: Exception) {
                throw GradleException(
                        "Failed to read bugvmProject BugVM config file in " + bugvmProject.projectDir.absolutePath, e)
            }

        }

        var installDir: File? = null
        if (extension.installDir != null) {
            installDir = File(extension.installDir)
        } else {
            installDir = File(bugvmProject.buildDir, "bugvm")
        }
        var cacheDir: File? = null
        if (extension.cacheDir != null) {
            cacheDir = File(extension.cacheDir!!)
        } else {
            cacheDir = Config.getDefaultCacheDir()
        }
        val temporaryDirectory = File(bugvmProject.buildDir, "bugvm.tmp")
        try {
            FileUtils.deleteDirectory(temporaryDirectory)
        } catch (e: IOException) {
            throw GradleException("Failed to clean output dir " + temporaryDirectory, e)
        }

        temporaryDirectory.mkdirs()

        builder.home(Config.Home(unpack()))
                .tmpDir(temporaryDirectory)
                .skipInstall(true)
                .installDir(installDir)
                .cacheDir(cacheDir)

        if (bugvmProject.hasProperty("mainClassName")) {
            builder.mainClass(bugvmProject.property("mainClassName") as String)
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
                builder.iosSignIdentity(SigningIdentity.find(SigningIdentity.list(), iosSignIdentity))
            }

            if (extension.iosProvisioningProfile != null) {
                val iosProvisioningProfile = extension.iosProvisioningProfile

                logger.debug("Using explicit iOS provisioning profile: " + iosProvisioningProfile)
                builder.iosProvisioningProfile(ProvisioningProfile.find(ProvisioningProfile.list(),
                        iosProvisioningProfile))
            }
        }

        builder.clearClasspathEntries()

        // configure the runtime classpath
        val classpathEntries = bugvmProject.configurations.getByName("runtime").files
        classpathEntries.add(File(bugvmProject.buildDir, "classes/main"))

        if (bugvmProject.hasProperty("output.classesDir")) {
            classpathEntries.add(bugvmProject.property("output.classesDir") as File)
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

    @TaskAction
    abstract operator fun invoke()

    @Throws(GradleException::class)
    protected fun unpack(): File {
        val artifact = resolveArtifact("com.bugvm:bugvm-dist:tgz:" + BugVMPlugin.bugVMVersion)
        val distTarFile = artifact.file
        val unpackedDirectory = File(distTarFile.parent, "unpacked")
        val unpackedDistDirectory = File(unpackedDirectory, "bugvm-" + BugVMPlugin.bugVMVersion)

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
                throw GradleException("Unable to create base directory to unpack into: " + unpackedDirectory)
            }

            try {
                extractTarGz(distTarFile, unpackedDirectory)
            } catch (e: IOException) {
                throw GradleException("Couldn't extract distribution tgz", e)
            }

            if (!unpackedDistDirectory.exists()) {
                throw GradleException("Unable to unpack archive")
            }

            logger.debug("Archive '$distTarFile' unpacked to: $unpackedDirectory")
        }

        ant.invokeMethod("chmod", object : HashMap<String, Any>() {
            init {
                put("dir", File(unpackedDistDirectory, "bin").absoluteFile)
                put("perm", "+x")
                put("includes", "*")
            }
        })

        return unpackedDistDirectory
    }

    @Throws(GradleException::class)
    protected fun resolveArtifact(artifactLocator: String): Artifact {
        val request = ArtifactRequest()
        val artifact = DefaultArtifact(artifactLocator)
        request.artifact = artifact
        request.repositories = remoteRepositories

        logger.debug("Resolving artifact $artifact from $remoteRepositories")

        val result: ArtifactResult

        try {
            result = repositorySystem.resolveArtifact(repositorySystemSession, request)
        } catch (e: ArtifactResolutionException) {
            throw GradleException(e.message, e)
        }

        logger.debug(
                "Resolved artifact " + artifact + " to " + result.artifact.file + " from "
                        + result.repository)

        return result.artifact
    }

    protected fun GetBugVMLogger(): Logger {
        if (bugVMLogger == null) {
            bugVMLogger = object : Logger {
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

        return bugVMLogger!!
    }

    private fun createRepositorySystem(): RepositorySystem {
        val locator = MavenServiceLocator()
        locator.addService(RepositoryConnectorFactory::class.java, WagonRepositoryConnectorFactory::class.java)
        locator.setService(WagonProvider::class.java, ManualWagonProvider::class.java)

        return locator.getService(RepositorySystem::class.java)
    }

    private fun createRepositorySystemSession(): RepositorySystemSession {
        val localRepository = LocalRepository(System.getProperty("user.home") + "/.m2/repository")
        val session = MavenRepositorySystemSession()
        session.localRepositoryManager = repositorySystem.newLocalRepositoryManager(localRepository)

        return session
    }

    private fun createRemoteRepositories(): List<RemoteRepository> {
        val repositories = ArrayList<RemoteRepository>()
        repositories.add(RemoteRepository("maven-central", "default", "http://repo1.maven.org/maven2/"))
        repositories.add(RemoteRepository("oss.sonatype.org-snapshots", "default",
                "https://oss.sonatype.org/content/repositories/snapshots/"))

        return repositories
    }

    @Throws(IOException::class)
    private fun extractTarGz(archive: File, destDir: File) {
        var `in`: TarArchiveInputStream? = null
        try {
            `in` = TarArchiveInputStream(GZIPInputStream(FileInputStream(archive)))
            var entry: ArchiveEntry = `in`.nextEntry
            while (entry != null) {
                val f = File(destDir, entry!!.name)
                if (entry.isDirectory) {
                    f.mkdirs()
                } else {
                    f.parentFile.mkdirs()
                    var out: OutputStream? = null
                    try {
                        out = FileOutputStream(f)
                        IOUtils.copy(`in`, out)
                    } finally {
                        IOUtils.closeQuietly(out)
                    }
                }
                f.setLastModified(entry.lastModifiedDate.time)
                if (entry is TarArchiveEntry) {
                    val mode = entry.mode
                    if (mode and 64 > 0) {
                        // Preserve execute permissions
                        f.setExecutable(true, mode and 1 == 0)
                    }
                }
                entry = `in`.nextEntry
            }
        } finally {
            IOUtils.closeQuietly(`in`)
        }
    }

    class ManualWagonProvider : WagonProvider {

        @Throws(Exception::class)
        override fun lookup(roleHint: String): Wagon? {
            if ("http" == roleHint || "https" == roleHint) {
                return HttpWagon()
            }

            return null
        }

        override fun release(wagon: Wagon) {
            // noop
        }
    }
}