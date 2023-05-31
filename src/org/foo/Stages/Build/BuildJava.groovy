package org.foo.Stages.Build

class BuildJava {
    public Script script

    BuildJava() {
    }


    BuildJava(Script script) {
        this.script = script
    }

        void execute(String name) {
            script.stage(name) {
                script.echo "Triggering ${name} stage..."
                script.sh "mvn -B -DskipTests clean package"
            }    
        }
}
