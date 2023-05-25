package org.foo

class SonarqubeStage {
    public Script script


    SonarqubeStage(Script script) {
        this.script = script
    }

    void execute(String name) {
        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            script.withSonarQubeEnv("Sonarqube") {

            def sonarProps = readProperties file: 'sonar-project.properties'
            script.sh "sonar-scanner -Dsonar.sources=${sonarProps.getProperty('sonar.sources')}"
            }
        }
    }
}
