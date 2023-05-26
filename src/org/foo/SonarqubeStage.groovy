package org.foo

import java.util.Properties

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
                script.readFile(file: 'sonar-project.properties') { propertiesContent ->
                    sonarProps.load(new StringReader(propertiesContent))
                }
                script.sh "sonar-scanner -Dsonar.sources=${sonarProps.getProperty('sonar.sources')}"
            }
        }
    }
}
