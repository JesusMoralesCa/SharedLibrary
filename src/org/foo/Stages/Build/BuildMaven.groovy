package org.foo.Stages.Build

class BuildMaven {
    public Script script

    BuildMaven() {
    }


    BuildMaven(Script script) {
        this.script = script
    }

        void execute(String name) {
            script.stage(name) {
                script.echo "Triggering ${name} stage..."
                script.sh "mvn -B -DskipTests clean package"
            }    
        }
}
