package org.foo

class SonarqubeStage {
    public Script script

    SonarqubeStage(Script script) {
        this.script = script
    }

    void execute(String name) {
        def sonarProps = [
            'sonar.host.url': 'http://172.21.0.1:9000',
            'sonar.login': 'sonarqube',
            'sonar.projectKey': 'pipeline-template',
            'sonar.sources': 'src',
            'sonar.language': 'groovy'
        ]

        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            def scannerHome = script.tool 'SonarScanner'
            script.withSonarQubeEnv(sonarProps) {
                    script.sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=${sonarProps['sonar.projectKey']} -Dsonar.sources=${sonarProps['sonar.sources']} -Dsonar.language=${sonarProps['sonar.language']}"
                
            }
        }
    }
}

