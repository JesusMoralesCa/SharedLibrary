package org.foo

import jenkins.model.Jenkins

class srcMavenCleanPackage {
    def script = "mvn -B -DskipTests clean package"

    void cleanPackage() {
        def sh = Jenkins.instance.createLauncher(null).launch()
        sh.writeLine(script)
        sh.waitForOrKill(10000)
    }

    void run() {
        cleanPackage()
    }
}

