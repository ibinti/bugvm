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
package com.bugvm.gradle;

/**
 *
 * @author Junji Takakura
 */
public class BugVMPluginExtension {

    public static final String NAME = "bugvm";
    private final org.gradle.api.Project project;
    private String propertiesFile;
    private String configFile;
    private String iosSignIdentity;
    private String iosProvisioningProfile;
    private String iosSimulatorSdk;
    private String stdoutFifo;
    private String stderrFifo;
    private String os;
    private String arch;
    private boolean iosSkipSigning = false;
    private boolean debug = false;
    private int debugPort = -1;
    private boolean skipLaunch = false;
    private String archs;
    private String installDir;    
    private String cacheDir;

    public BugVMPluginExtension(org.gradle.api.Project project) {
        this.project = project;
    }

    public org.gradle.api.Project getProject() {
        return project;
    }

    public String getPropertiesFile() {
        return propertiesFile;
    }

    public void setPropertiesFile(String propertiesFile) {
        this.propertiesFile = propertiesFile;
    }

    public String getConfigFile() {
        return configFile;
    }

    public void setConfigFile(String configFile) {
        this.configFile = configFile;
    }

    public String getIosSignIdentity() {
        return project.hasProperty("bugvm.iosSignIdentity")
                ? project.getProperties().get("bugvm.iosSignIdentity").toString()
                : iosSignIdentity;
    }

    public void setIosSignIdentity(String iosSignIdentity) {
        this.iosSignIdentity = iosSignIdentity;
    }

    public String getIosProvisioningProfile() {
        return project.hasProperty("bugvm.iosProvisioningProfile")
                ? project.getProperties().get("bugvm.iosProvisioningProfile").toString()
                : iosProvisioningProfile;
    }

    public void setIosProvisioningProfile(String iosProvisioningProfile) {
        this.iosProvisioningProfile = iosProvisioningProfile;
    }

    public String getIosSimulatorSdk() {
        return project.hasProperty("bugvm.iosSimulatorSdk")
                ? project.getProperties().get("bugvm.iosSimulatorSdk").toString()
                : iosSimulatorSdk;
    }

    public void setIosSimulatorSdk(String iosSimulatorSdk) {
        this.iosSimulatorSdk = iosSimulatorSdk;
    }

    public String getStdoutFifo() {
        return stdoutFifo;
    }

    public void setStdoutFifo(String stdoutFifo) {
        this.stdoutFifo = stdoutFifo;
    }

    public String getStderrFifo() {
        return stderrFifo;
    }

    public void setStderrFifo(String stderrFifo) {
        this.stderrFifo = stderrFifo;
    }

    public boolean isIosSkipSigning() {
        return project.hasProperty("bugvm.iosSkipSigning")
                ? Boolean.parseBoolean(project.getProperties().get("bugvm.iosSkipSigning").toString())
                : iosSkipSigning;
    }

    public void setIosSkipSigning(boolean iosSkipSigning) {
        this.iosSkipSigning = iosSkipSigning;
    }

    public String getOs() {
        return project.hasProperty("bugvm.os") ? project.getProperties().get("bugvm.os").toString() : os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getArch() {
        return project.hasProperty("bugvm.arch") ? project.getProperties().get("bugvm.arch").toString() : arch;
    }

    public void setArch(String arch) {
        this.arch = arch;
    }
    
    public boolean isDebug() {
        return project.hasProperty("bugvm.debug")
                ? Boolean.parseBoolean(project.getProperties().get("bugvm.debug").toString())
                : debug;
    }
    
    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public boolean isSkipLaunch() {
        return project.hasProperty("bugvm.skipLaunch")
                ? Boolean.parseBoolean(project.getProperties().get("bugvm.skipLaunch").toString())
                : skipLaunch;
    }

    public void setSkipLaunch(boolean skipLaunch) {
        this.skipLaunch = skipLaunch;
    }
    
    public int getDebugPort() {
        return project.hasProperty("bugvm.debugPort")
                ? Integer.parseInt(project.getProperties().get("bugvm.debugPort").toString())
                : debugPort;
    }
    
    public void setDebugPort(int debugPort) {
        this.debugPort = debugPort;
    }
    
    public String getArchs() {
        if (project.hasProperty("bugvm.archs")) {
            return project.getProperties().get("bugvm.archs").toString();
        }
        return archs;
    }
    
    public void setArchs(String ipaArchs) {
        this.archs = ipaArchs;
    }

    public String getInstallDir() {
        return project.hasProperty("bugvm.installDir") ? project.getProperties().get("bugvm.installDir").toString() : installDir;
    }

    public void setInstallDir(String installDir) {
        this.installDir = installDir;
    }
    
    public void setCacheDir(String cacheDir) {
        this.cacheDir = cacheDir;
    }
    
    public String getCacheDir() {
        return project.hasProperty("bugvm.cacheDir") ? project.getProperties().get("bugvm.cacheDir").toString() : null;
    }
}
