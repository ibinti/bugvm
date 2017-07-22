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
package com.bugvm.gradle.tasks;

import org.sonatype.aether.RepositorySystem;
import org.sonatype.aether.RepositorySystemSession;
import org.sonatype.aether.artifact.Artifact;
import org.sonatype.aether.connector.wagon.WagonProvider;
import org.sonatype.aether.connector.wagon.WagonRepositoryConnectorFactory;
import org.sonatype.aether.repository.LocalRepository;
import org.sonatype.aether.repository.RemoteRepository;
import org.sonatype.aether.resolution.ArtifactRequest;
import org.sonatype.aether.resolution.ArtifactResolutionException;
import org.sonatype.aether.resolution.ArtifactResult;
import org.sonatype.aether.spi.connector.RepositoryConnectorFactory;
import org.sonatype.aether.util.artifact.DefaultArtifact;

/**
 *
 * @author Junji Takakura
 */
abstract public class AbstractBugVMTask extends org.gradle.api.DefaultTask {

    protected final org.gradle.api.Project project;
    protected final com.bugvm.gradle.BugVMPluginExtension extension;
    protected final RepositorySystem repositorySystem;
    protected final RepositorySystemSession repositorySystemSession;
    protected final java.util.List<RemoteRepository> remoteRepositories;
    protected com.bugvm.compiler.log.Logger bugVMLogger;

    public AbstractBugVMTask() {

        project = getProject();
        extension = (com.bugvm.gradle.BugVMPluginExtension) project.getExtensions().getByName(com.bugvm.gradle.BugVMPluginExtension.NAME);
        repositorySystem = createRepositorySystem();
        repositorySystemSession = createRepositorySystemSession();
        remoteRepositories = createRemoteRepositories();
    }

    public com.bugvm.compiler.AppCompiler build(com.bugvm.compiler.config.OS os, com.bugvm.compiler.config.Arch arch, String targetType) {
        getLogger().info("Building BugVM app for: " + os + " (" + arch + ")");

        com.bugvm.compiler.config.Config.Builder builder;
        try {
            builder = new com.bugvm.compiler.config.Config.Builder();
        } catch (java.io.IOException e) {
            throw new org.gradle.api.GradleException(e.getMessage(), e);
        }

        configure(builder).os(os).arch(arch).targetType(targetType);

        // execute the BugVM build
        com.bugvm.compiler.config.Config config;

        try {
            getLogger().info("Compiling BugVM app, this could take a while, especially the first time round");
            config = builder.build();
            com.bugvm.compiler.AppCompiler compiler = new com.bugvm.compiler.AppCompiler(config);
            compiler.build();
            getLogger().info("Compile BugVM app completed.");
            return compiler;
        } catch (java.io.IOException e) {
            throw new org.gradle.api.GradleException("Error building BugVM executable for app", e);
        }
    }

    protected com.bugvm.compiler.config.Config.Builder configure(com.bugvm.compiler.config.Config.Builder builder) {
        builder.logger(getBugVMLogger());

        if (extension.getPropertiesFile() != null) {
            java.io.File propertiesFile = new java.io.File(extension.getPropertiesFile());

            if (!propertiesFile.exists()) {
                throw new org.gradle.api.GradleException("Invalid 'propertiesFile' specified for BugVM compile: " + propertiesFile);
            }
            try {
                getLogger().debug(
                        "Including properties file in BugVM compiler config: " + propertiesFile.getAbsolutePath());
                builder.addProperties(propertiesFile);
            } catch (java.io.IOException e) {
                throw new org.gradle.api.GradleException("Failed to add properties file to BugVM config: " + propertiesFile);
            }
        } else {
            try {
                builder.readProjectProperties(project.getProjectDir(), false);
            } catch (java.io.IOException e) {
                throw new org.gradle.api.GradleException(
                        "Failed to read BugVM project properties file(s) in "
                                + project.getProjectDir().getAbsolutePath(), e);
            }
        }

        if (extension.getConfigFile() != null) {
            java.io.File configFile = new java.io.File(extension.getConfigFile());

            if (!configFile.exists()) {
                throw new org.gradle.api.GradleException("Invalid 'configFile' specified for BugVM compile: " + configFile);
            }
            try {
                getLogger().debug("Loading config file for BugVM compiler: " + configFile.getAbsolutePath());
                builder.read(configFile);
            } catch (Exception e) {
                throw new org.gradle.api.GradleException("Failed to read BugVM config file: " + configFile);
            }
        } else {
            try {
                builder.readProjectConfig(project.getProjectDir(), false);
            } catch (Exception e) {
                throw new org.gradle.api.GradleException(
                        "Failed to read project BugVM config file in "
                                + project.getProjectDir().getAbsolutePath(), e);
            }
        }

        java.io.File installDir = null;
        if (extension.getInstallDir() != null) {
            installDir = new java.io.File(extension.getInstallDir());
        } else {
            installDir = new java.io.File(project.getBuildDir(), "bugvm");
        }
        java.io.File cacheDir = null;
        if(extension.getCacheDir() != null) {
            cacheDir = new java.io.File(extension.getCacheDir());
        } else {
            cacheDir = com.bugvm.compiler.config.Config.getDefaultCacheDir();
        }
        java.io.File temporaryDirectory = new java.io.File(project.getBuildDir(), "bugvm.tmp");
        try {
            org.apache.commons.io.FileUtils.deleteDirectory(temporaryDirectory);
        } catch (java.io.IOException e) {
            throw new org.gradle.api.GradleException("Failed to clean output dir " + temporaryDirectory, e);
        }
        temporaryDirectory.mkdirs();

        builder.home(new com.bugvm.compiler.config.Config.Home(unpack()))
                .tmpDir(temporaryDirectory)
                .skipInstall(true)
                .installDir(installDir)
                .cacheDir(cacheDir);

        if (project.hasProperty("mainClassName")) {
            builder.mainClass((String) project.property("mainClassName"));
        }

        if (extension.isDebug()) {
            builder.debug(true);
            if (extension.getDebugPort() != -1) {
                builder.addPluginArgument("debug:jdwpport=" + extension.getDebugPort());
            }
        }

        if (extension.isIosSkipSigning()) {
            builder.iosSkipSigning(true);
        } else {
            if (extension.getIosSignIdentity() != null) {
                String iosSignIdentity = extension.getIosSignIdentity();

                getLogger().debug("Using explicit iOS Signing identity: " + iosSignIdentity);
                builder.iosSignIdentity(com.bugvm.compiler.target.ios.SigningIdentity.find(com.bugvm.compiler.target.ios.SigningIdentity.list(), iosSignIdentity));
            }

            if (extension.getIosProvisioningProfile() != null) {
                String iosProvisioningProfile = extension.getIosProvisioningProfile();

                getLogger().debug("Using explicit iOS provisioning profile: " + iosProvisioningProfile);
                builder.iosProvisioningProfile(com.bugvm.compiler.target.ios.ProvisioningProfile.find(com.bugvm.compiler.target.ios.ProvisioningProfile.list(),
                        iosProvisioningProfile));
            }
        }

        builder.clearClasspathEntries();

        // configure the runtime classpath
        java.util.Set<java.io.File> classpathEntries = project.getConfigurations().getByName("runtime").getFiles();

/* Gradle 4.0 breaking change
build/classes/${sourceSet.name}
to
build/classes/${sourceDirectorySet.name}/${sourceSet.name}

The collection of all of the output directories : SourceSetOutput#getClassesDirs()
 */
        final org.gradle.api.plugins.JavaPluginConvention javaPluginConvention = project.getConvention().getPlugin(org.gradle.api.plugins.JavaPluginConvention.class);
        final org.gradle.api.tasks.SourceSet main = javaPluginConvention.getSourceSets().getByName(org.gradle.api.tasks.SourceSet.MAIN_SOURCE_SET_NAME);
        try {
            classpathEntries.addAll(main.getOutput().getClassesDirs().getFiles());
        }  catch (java.lang.NoSuchMethodError e) {
            // Gradle 3.*: exception
        }
        try {
            classpathEntries.add(main.getOutput().getClassesDir());
        }  catch (java.lang.NoSuchMethodError e) {
            //Gradle 4.0 : deprecated
            //Gradle 5.0 : exception
        }

        if (project.hasProperty("output.classesDir")) {
            classpathEntries.add((java.io.File) project.property("output.classesDir"));
        }

        for (java.io.File classpathEntry : classpathEntries) {
            if (getLogger().isDebugEnabled()) {
                getLogger().debug("Including classpath element for BugVM app: " + classpathEntry.getAbsolutePath());
            }

            if(classpathEntry.getName().startsWith("bugvm-rt")) {
                builder.addBootClasspathEntry(classpathEntry);
            } else {
                builder.addClasspathEntry(classpathEntry);
            }
        }

        return builder;
    }

    @org.gradle.api.tasks.TaskAction
    abstract public void invoke();

    protected java.io.File unpack() throws org.gradle.api.GradleException {
        final Artifact artifact = resolveArtifact("com.bugvm:bugvm-dist:tgz:" + com.bugvm.gradle.BugVMPlugin.getBugVMVersion());
        final java.io.File distTarFile = artifact.getFile();
        final java.io.File unpackedDirectory = new java.io.File(distTarFile.getParent(), "unpacked");
        final java.io.File unpackedDistDirectory = new java.io.File(unpackedDirectory, "bugvm-" + com.bugvm.gradle.BugVMPlugin.getBugVMVersion());

        if (unpackedDirectory.exists() && artifact.isSnapshot()) {
            getAnt().invokeMethod("delete", new java.util.HashMap<String, Object>() {
                {
                    put("dir", unpackedDirectory.getAbsolutePath());
                }
            });
        }

        if (unpackedDirectory.exists()) {
            getLogger().debug("Archive '" + distTarFile + "' was already unpacked in: " + unpackedDirectory);
        } else {
            getLogger().info("Extracting '" + distTarFile + "' to: " + unpackedDirectory);

            if (!unpackedDirectory.mkdirs()) {
                throw new org.gradle.api.GradleException("Unable to create base directory to unpack into: " + unpackedDirectory);
            }

            try {
                extractTarGz(distTarFile, unpackedDirectory);
            } catch (java.io.IOException e) {
                throw new org.gradle.api.GradleException("Couldn't extract distribution tgz", e);
            }

            if (!unpackedDistDirectory.exists()) {
                throw new org.gradle.api.GradleException("Unable to unpack archive");
            }

            getLogger().debug("Archive '" + distTarFile + "' unpacked to: " + unpackedDirectory);
        }

        getAnt().invokeMethod("chmod", new java.util.HashMap<String, Object>() {
            {
                put("dir", new java.io.File(unpackedDistDirectory, "bin").getAbsoluteFile());
                put("perm", "+x");
                put("includes", "*");
            }
        });

        return unpackedDistDirectory;
    }

    protected Artifact resolveArtifact(String artifactLocator) throws org.gradle.api.GradleException {
        ArtifactRequest request = new ArtifactRequest();
        DefaultArtifact artifact = new DefaultArtifact(artifactLocator);
        request.setArtifact(artifact);
        request.setRepositories(remoteRepositories);

        getLogger().debug("Resolving artifact " + artifact + " from " + remoteRepositories);

        ArtifactResult result;

        try {
            result = repositorySystem.resolveArtifact(repositorySystemSession, request);
        } catch (ArtifactResolutionException e) {
            throw new org.gradle.api.GradleException(e.getMessage(), e);
        }

        getLogger().debug(
                "Resolved artifact " + artifact + " to " + result.getArtifact().getFile() + " from "
                        + result.getRepository());

        return result.getArtifact();
    }

    protected com.bugvm.compiler.log.Logger getBugVMLogger() {
        if (bugVMLogger == null) {
            bugVMLogger = new com.bugvm.compiler.log.Logger() {
                @Override
                public void debug(String s, Object... objects) {
                    getLogger().debug(String.format(s, objects));
                }

                @Override
                public void info(String s, Object... objects) {
                    getLogger().info(String.format(s, objects));
                }

                @Override
                public void warn(String s, Object... objects) {
                    getLogger().warn(String.format(s, objects));
                }

                @Override
                public void error(String s, Object... objects) {
                    getLogger().error(String.format(s, objects));
                }
            };
        }

        return bugVMLogger;
    }

    private RepositorySystem createRepositorySystem() {
        org.apache.maven.repository.internal.MavenServiceLocator locator = new org.apache.maven.repository.internal.MavenServiceLocator();
        locator.addService(RepositoryConnectorFactory.class, WagonRepositoryConnectorFactory.class);
        locator.setService(WagonProvider.class, ManualWagonProvider.class);

        return locator.getService(RepositorySystem.class);
    }

    private RepositorySystemSession createRepositorySystemSession() {
        LocalRepository localRepository = new LocalRepository(System.getProperty("user.home") + "/.m2/repository");
        org.apache.maven.repository.internal.MavenRepositorySystemSession session = new org.apache.maven.repository.internal.MavenRepositorySystemSession();
        session.setLocalRepositoryManager(repositorySystem.newLocalRepositoryManager(localRepository));

        return session;
    }

    private java.util.List<RemoteRepository> createRemoteRepositories() {
        java.util.List<RemoteRepository> repositories = new java.util.ArrayList<>();
        repositories.add(new RemoteRepository("maven-central", "default", "http://repo1.maven.org/maven2/"));
        repositories.add(new RemoteRepository("oss.sonatype.org-snapshots", "default",
                "https://oss.sonatype.org/content/repositories/snapshots/"));

        return repositories;
    }

    private static void extractTarGz(java.io.File archive, java.io.File destDir) throws java.io.IOException {
        org.apache.commons.compress.archivers.tar.TarArchiveInputStream in = null;
        try {
            in = new org.apache.commons.compress.archivers.tar.TarArchiveInputStream(new java.util.zip.GZIPInputStream(new java.io.FileInputStream(archive)));
            org.apache.commons.compress.archivers.ArchiveEntry entry = null;
            while ((entry = in.getNextEntry()) != null) {
                java.io.File f = new java.io.File(destDir, entry.getName());
                if (entry.isDirectory()) {
                    f.mkdirs();
                } else {
                    f.getParentFile().mkdirs();
                    java.io.OutputStream out = null;
                    try {
                        out = new java.io.FileOutputStream(f);
                        org.apache.commons.io.IOUtils.copy(in, out);
                    } finally {
                        org.apache.commons.io.IOUtils.closeQuietly(out);
                    }
                }
                f.setLastModified(entry.getLastModifiedDate().getTime());
                if (entry instanceof org.apache.commons.compress.archivers.tar.TarArchiveEntry) {
                    int mode = ((org.apache.commons.compress.archivers.tar.TarArchiveEntry) entry).getMode();
                    if ((mode & 00100) > 0) {
                        // Preserve execute permissions
                        f.setExecutable(true, (mode & 00001) == 0);
                    }
                }
            }
        } finally {
            org.apache.commons.io.IOUtils.closeQuietly(in);
        }
    }

    public static class ManualWagonProvider implements WagonProvider {

        @Override
        public org.apache.maven.wagon.Wagon lookup(String roleHint) throws Exception {
            if ("http".equals(roleHint) || "https".equals(roleHint)) {
                return new org.apache.maven.wagon.providers.http.HttpWagon();
            }

            return null;
        }

        @Override
        public void release(org.apache.maven.wagon.Wagon wagon) {
            // noop
        }
    }
}