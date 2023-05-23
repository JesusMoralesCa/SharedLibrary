package org.foo

class NodeTestJest {
    public Script script

    NodeTestJest() {

    }

    NodeTestJest(Script script) {
        this.script = script
    }

        void execute(String name) {
        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            script.sh "npm install --save jest"
            script.sh "NODE_OPTIONS=--experimental-vm-modules npx jest"
        }    
    }
}

