package org.foo

class SonarqubeStage {
    public Script script

    SonarqubeStage(Script script) {
        this.script = script
    }

    void execute(String name) {
        def sonarProps = [
            '-Dsonar.host.url=http://172.21.0.1:9000',
            '-Dsonar.projectKey=SonarqubeAnalisis',
            '-Dsonar.sources=src',
            '-Dsonar.language=groovy'
        ]

        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            def scannerHome = script.tool 'SonarScanner'
            script.withSonarQubeEnv() {
                    script.sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectSettings=${sonarProps}"
                
            }
        }
    }
}

