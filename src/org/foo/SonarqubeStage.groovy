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

                def sonarProps = new Properties()
                sonarProps.load(new FileInputStream('sonar-project.properties'))

                script.sh "sonar-scanner -Dsonar.sources=${sonarProps.getProperty('sonar.sources')}"
            }
        }
    }
}
