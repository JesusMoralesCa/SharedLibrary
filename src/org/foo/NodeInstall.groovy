package org.foo

class NodeInstall {
    public Script script

    NodeInstall() {

    }

    NodeInstall(Script script) {
        this.script = script
    }

        void execute(String name) {
        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            script.sh "npm install"
        }    
    }
}

