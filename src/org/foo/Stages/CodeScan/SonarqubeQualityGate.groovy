package org.foo.Stages.CodeScan

class SonarqubeQualityGate {
    public Script script

    SonarqubeQualityGate(Script script) {
        this.script = script
    }

    void execute(String name) {
        script.stage(name) {
            script.echo "Triggering ${name} stage..."

            script.waitForQualityGate abortPipeline: true
        }
    }
}