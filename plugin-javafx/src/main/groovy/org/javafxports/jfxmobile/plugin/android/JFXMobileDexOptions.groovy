package org.javafxports.jfxmobile.plugin.android

import com.android.build.gradle.internal.dsl.DexOptions

class JFXMobileDexOptions extends DexOptions {

    List<String> additionalParameters = []

    boolean keepRuntimeAnnotatedClasses = true

    void additionalParameters(String... parameters) {
        additionalParameters = Arrays.asList(parameters)
    }

    void keepRuntimeAnnotatedClasses(boolean keep) {
        this.keepRuntimeAnnotatedClasses = keep
    }
}
