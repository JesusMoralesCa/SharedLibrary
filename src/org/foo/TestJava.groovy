package org.foo

class TestJava {
    public Script script

    TestJava() {
        
    }

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
