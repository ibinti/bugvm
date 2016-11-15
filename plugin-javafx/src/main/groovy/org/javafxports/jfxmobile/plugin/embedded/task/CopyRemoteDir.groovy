package org.javafxports.jfxmobile.plugin.embedded.task

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.TaskAction
import org.javafxports.jfxmobile.plugin.embedded.RemotePlatformConfiguration

class CopyRemoteDir extends DefaultTask {

    @InputDirectory
    File from
    @Input
    RemotePlatformConfiguration remotePlatform

    @TaskAction
    void copyJar() {
        RemotePlatformConfiguration cfg = getRemotePlatform()

        if (cfg.password != null) {
            project.ant.sshexec(host: cfg.host, port: "${cfg.getPort()}", username: cfg.username, password: cfg.password, trust: 'true',
                    command: "mkdir -p ${cfg.workingDir}/${project.name}")
            project.ant.scp(todir: "${cfg.username}@${cfg.host}:${cfg.workingDir}/${project.name}", port: "${cfg.getPort()}", password: cfg.password, trust: 'true') {
                fileset(dir: getFrom())
            }
        } else {
            project.ant.sshexec(host: cfg.host, port: "${cfg.getPort()}", username: cfg.username, keyfile: cfg.keyfile, passphrase: cfg.passphrase, trust: 'true',
                    command: "mkdir -p ${cfg.workingDir}/${project.name}")
            project.ant.scp(todir: "${cfg.username}@${cfg.host}:${cfg.workingDir}/${project.name}", port: "${cfg.getPort()}", keyfile: cfg.keyfile, passphrase: cfg.passphrase, trust: 'true') {
                fileset(dir: getFrom())
            }
        }
    }
}
