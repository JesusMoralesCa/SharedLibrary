package org.foo

class SonarqubeStage {
    public Script script

    SonarqubeStage(Script script) {
        this.script = script
    }

    void execute(String name) {
        def sonarProps = [
            'sonar.projectKey': 'pipeline-template',
            'sonar.sources': 'src',
            'sonar.language': 'groovy'
        ]

        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            script.withSonarQubeEnv("sonarqube") {
                script.withEnv(sonarProps) {
                    script.sh "SonarScanner/bin/sonar-scanner"
                }
            }
        }
    }
}

