package org.javafxports.jfxmobile.plugin.android.task

import com.android.builder.model.SigningConfig
import com.android.ide.common.signing.KeystoreHelper
import com.android.utils.NullLogger
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.Optional
import org.gradle.api.tasks.TaskAction
import org.gradle.tooling.BuildException

/**
 * Creates the android debug store if it is missing.
 *
 * @author joeri
 */
class ValidateSigning extends DefaultTask {

    SigningConfig signingConfig

    @Input @Optional
    String getStoreLocation() {
        File storeFile = signingConfig.getStoreFile()
        if (storeFile != null) {
            return storeFile.absolutePath
        }
        return null
    }

    @TaskAction
    void validate() {
        File storeFile = signingConfig.getStoreFile()
        if (storeFile != null && !storeFile.exists()) {
            if (KeystoreHelper.defaultDebugKeystoreLocation().equals(storeFile.absolutePath)) {
                if (!KeystoreHelper.createDebugStore(
                        signingConfig.getStoreType(), signingConfig.getStoreFile(),
                        signingConfig.getStorePassword(), signingConfig.getKeyPassword(),
                        signingConfig.getKeyAlias(), NullLogger.getLogger())) {
                    throw new BuildException("Unable to create missing debug keystore.", null);
                }
            }
        }
    }

}
