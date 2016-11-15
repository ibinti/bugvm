package com.bugvm.gradle

import org.gradle.api.Project
import org.gradle.internal.reflect.Instantiator
import org.gradle.util.ConfigureUtil
import com.bugvm.gradle.android.AndroidExtension
import com.bugvm.gradle.embedded.EmbeddedExtension
import com.bugvm.gradle.ios.IosExtension

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
