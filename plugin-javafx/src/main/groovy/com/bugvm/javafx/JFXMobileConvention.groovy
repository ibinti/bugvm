package com.bugvm.javafx

import org.gradle.api.Project

/**
 *
 * @author joeri
 */
class JFXMobileConvention {

    /**
     * The fully qualified name of the application's Preloader class.
     */
    String preloaderClassName

    final Project project

    JFXMobileConvention(Project project) {
        this.project = project
    }

}
