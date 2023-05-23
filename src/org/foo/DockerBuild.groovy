//         credentials('docker-hub-jesusmoralesc')
package org.foo

class DockerBuild {
    public Script script

    DockerBuild() {

    }

    DockerBuild(Script script) {
        this.script = script
    }

        void execute(String name) {
        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            script.sh "docker build -t jesusmoralesc/docker-${file['imageName']} ."
        }    
    }
}
