package org.javafxports.jfxmobile.plugin

import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator
import org.gradle.util.ConfigureUtil
import org.javafxports.jfxmobile.plugin.android.AndroidExtension
import org.javafxports.jfxmobile.plugin.embedded.EmbeddedExtension
import org.javafxports.jfxmobile.plugin.ios.IosExtension

/**
 *
 * @author joeri
 */
class JFXMobileExtension {

    String javacEncoding = 'utf-8'
    String javafxportsVersion = "8.60.8"

    DownConfiguration downConfig

    public JFXMobileExtension(Project project, Instantiator instantiator) {
        extensions.create("android", AndroidExtension, project)
        extensions.create("ios", IosExtension, project)
        extensions.create("embedded", EmbeddedExtension, project)

        downConfig = instantiator.newInstance(DownConfiguration, project)
    }

    void downConfig(Closure configureClosure) {
        ConfigureUtil.configure(configureClosure, downConfig)
    }
}
