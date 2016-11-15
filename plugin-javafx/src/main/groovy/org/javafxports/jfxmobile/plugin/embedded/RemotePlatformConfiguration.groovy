package org.javafxports.jfxmobile.plugin.embedded

import org.gradle.api.Named

class RemotePlatformConfiguration implements Named {

    protected final String name

    String host
    int port

    String username
    String password
    File keyfile
    String passphrase

    String execPrefix = ''
    String jreLocation
    String workingDir

    RemotePlatformConfiguration(String name) {
        this.name = name
    }

    String getName() {
        return name
    }

    int getPort() {
        if (port.equals(0)) {
            return 22
        }
        return port
    }
}
