package org.foo

import java.util.Properties
import java.io.FileInputStream

class SonarqubeStage {
    public Script script

    SonarqubeStage(Script script) {
        this.script = script
    }

    void execute(String name) {
        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            script.withSonarQubeEnv("sonarqube") {

                //def sonarProps = file2
                

                script.sh "sonar-scanner -Dsonar.sources=src}"
            }
        }
    }
}
