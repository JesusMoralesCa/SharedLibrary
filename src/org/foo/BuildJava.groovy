package org.foo
import org.foo.Stage

class BuildJava {
    private final Script script

    BuildJava(Script script) {
        this.script = script
    }

 
        void execute(String name) {
        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            script.sh "mvn -B -DskipTests clean package"
        }
    
}
