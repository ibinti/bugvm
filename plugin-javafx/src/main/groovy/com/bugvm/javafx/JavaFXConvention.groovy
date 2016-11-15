package com.bugvm.javafx

import org.gradle.api.Project

/**
 *
 * @author joeri
 */
class JavaFXConvention {

    /**
     * The fully qualified name of the application's Preloader class.
     */
    String preloaderClassName

    final Project project

    JavaFXConvention(Project project) {
        this.project = project
    }

}
