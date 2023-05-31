package org.foo.Stages.Build

class BuildNode {
    public Script script

    BuildNode() {

    }

    BuildNode(Script script) {
        this.script = script
    }

        void execute(String name) {
        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            script.sh "npm install"
        }    
    }
}

