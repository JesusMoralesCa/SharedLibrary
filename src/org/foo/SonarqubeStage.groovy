package org.foo

class SonarqubeStage {
    public Script script

    SonarqubeStage() {
        
    }

    SonarqubeStage(Script script, String sonarQubeEnv) {
        this.script = script
    }

    void execute(String name) {
        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            script.withSonarQubeEnv("sonarqube") {

            def sonarProps = readProperties file: 'sonar-project.properties'
            script.sh "sonar-scanner -Dsonar.sources=${sonarProps.getProperty('sonar.sources')}"
            }
        }
    }
}
