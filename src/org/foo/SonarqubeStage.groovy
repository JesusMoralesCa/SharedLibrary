package org.foo

class SonarqubeStage {
    public Script script

    SonarqubeStage(Script script) {
        this.script = script
    }

void execute(String name) {
        def sonarProps = [
            'sonar.host.url': 'http://172.21.0.1:9000',
            'sonar.login': 'squ_34a79036fb8a3e556be4c083e435e5cc9c523967',
            'sonar.projectKey': 'pipeline-template',
            'sonar.sources': 'src',
            'sonar.language': 'groovy'
        ]

        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            def scannerHome = script.tool 'SonarScanner'
            script.withSonarQubeEnv() {
                script.withEnv(["SONAR_HOST_URL=${sonarProps['sonar.host.url']}", "SONAR_PROJECT_KEY=${sonarProps['sonar.projectKey']}", "SONAR_SOURCES=${sonarProps['sonar.sources']}", "SONAR_LANGUAGE=${sonarProps['sonar.language']}"]) {
                    script.sh "${scannerHome}/bin/sonar-scanner"
                }
            }
        }
    }
}

