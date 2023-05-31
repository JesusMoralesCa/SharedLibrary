package org.foo.Stages.Test

class TestMaven {
    public Script script

    TestMaven() {
        
    }

    TestMaven(Script script) {
        this.script = script
    }

        void execute(String name) {
        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            script.sh "mvn test"
        }    
    }
}
