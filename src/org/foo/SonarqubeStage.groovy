package org.foo

class SonarqubeStage {
    public Script script

    SonarqubeStage(Script script) {
        this.script = script
    }

    void execute(String name, tecnology) {
        def sonarProps = [
            'sonar.host.url': 'http://172.21.0.1:9000',
            'sonar.login': 'squ_34a79036fb8a3e556be4c083e435e5cc9c523967',
            'sonar.projectKey': 'pipeline-template',
            'sonar.language': 'groovy'
        ]

        script.stage(name, tecnology) {
            script.echo "Triggering ${name} stage..."
            def scannerHome = script.tool 'SonarScanner'


        if(${name} == Maven){
                def propertiesFile = script.newFile("sonar-project.properties")
                propertiesFile.write("""
                    sonar.host.url=${sonarProps['sonar.host.url']}
                    sonar.projectKey=${sonarProps['sonar.projectKey']}
                    sonar.sources=${sonarProps['sonar.sources']}
                    sonar.language=${sonarProps['sonar.language']}
                """.stripIndent())
        }

                
            script.withSonarQubeEnv() {
                    script.sh "${scannerHome}/bin/sonar-scanner "
                
            }
        }
    }
}

