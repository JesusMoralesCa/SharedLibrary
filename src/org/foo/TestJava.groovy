package org.foo

class TestJava {
    private final Script script

    TestJava(Script script) {
        this.script = script
    }

        void execute(String name) {
        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            script.sh "mvn test"
        }    
    }
}
