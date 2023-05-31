package org.foo

class SonarqubeStage {
    public Script script

    SonarqubeStage(Script script) {
        this.script = script
    }

    void execute(String name, String tecnology) {

        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            def scannerHome = script.tool 'SonarScanner'

            def propertiesFile = new File("/var/jenkins_home/workspace/TareaSonarqube/sonar-project.properties")
            propertiesFile.createNewFile()

        if (tecnology == "Maven") {
            propertiesFile.write('''
                sonar.projectKey=pipeline-template
                sonar.sources=src
                sonar.java.binaries=target/classes
            ''')
        }
        if (tecnology == "Node") {
            propertiesFile.write('''
                sonar.projectKey=pipeline-template
                sonar.sources=./
                sonar.language=js
                sonar.sourceEncoding=UTF-8
            ''')
        }
                
            script.withSonarQubeEnv() {
                    script.sh "${scannerHome}/bin/sonar-scanner "
                
            }
        }
    }
}

