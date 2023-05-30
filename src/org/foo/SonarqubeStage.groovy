package org.foo

class SonarqubeStage {
    public Script script

    SonarqubeStage(Script script) {
        this.script = script
    }

    void execute(String name) {
        def sonarProps = [
            '-Dsonar.host.url=http://172.21.0.1:9000',
            '-Dsonar.login=squ_34a79036fb8a3e556be4c083e435e5cc9c523967',
            '-Dsonar.projectKey=pipeline-template',
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

