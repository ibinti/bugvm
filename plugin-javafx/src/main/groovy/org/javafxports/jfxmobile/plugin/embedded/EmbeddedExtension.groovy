package org.javafxports.jfxmobile.plugin.embedded

import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project

class EmbeddedExtension {

    NamedDomainObjectContainer<RemotePlatformConfiguration> remotePlatforms

    public EmbeddedExtension(Project project) {
        remotePlatforms = project.container(RemotePlatformConfiguration)
    }

    void remotePlatforms(Closure config) {
        remotePlatforms.configure(config)
    }
}
