package org.javafxports.jfxmobile.plugin.embedded.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction
import org.javafxports.jfxmobile.plugin.embedded.RemotePlatformConfiguration

class RunEmbedded extends DefaultTask {

    @Input
    RemotePlatformConfiguration remotePlatform

    @TaskAction
    void runEmbedded() {
        RemotePlatformConfiguration cfg = getRemotePlatform()

        def command = "cd ${cfg.workingDir}/${project.name}; ${cfg.execPrefix} '${cfg.jreLocation}/bin/java' -Dfile.encoding=UTF-8 -classpath '*' ${project.mainClassName}"
        if (cfg.password != null) {
            project.ant.sshexec(host: cfg.host, port: "${cfg.getPort()}", username: cfg.username, password: cfg.password, trust: 'true', usepty: 'true', command: command)
        } else {
            project.ant.sshexec(host: cfg.host, port: "${cfg.getPort()}", username: cfg.username, keyfile: cfg.keyfile, passphrase: cfg.passphrase, trust: 'true', usepty: 'true', command: command)
        }
    }

}
