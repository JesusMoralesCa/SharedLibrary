package org.foo.Stages.CodeScan

class SonarqubeStage {
    public Script script

    SonarqubeStage(Script script) {
        this.script = script
    }

    void execute(String name, String tecnology) {

        script.stage(name) {
            script.echo "Triggering ${name} stage..."
            def scannerHome = script.tool 'SonarScanner'


            def propertiesFile = new File("${script.env.WORKSPACE}/sonar-project.properties")
            propertiesFile.createNewFile()

        if (tecnology == "Maven") {
            propertiesFile.write('''
                sonar.projectKey=MavenAnalysis
                sonar.sources=src
                sonar.java.binaries=target/classes
                sonar.sourceEncoding=UTF-8
            ''')
        }
        if (tecnology == "Node") {
            propertiesFile.write('''
                sonar.projectKey=NodeAnalysis
                sonar.sources=./
                sonar.language=js
                sonar.sourceEncoding=UTF-8
                sonar.exclusions=node_modules/*
            ''')
        }
                
            script.withSonarQubeEnv() {
                    script.sh "${scannerHome}/bin/sonar-scanner "
                
            }
        }
    }
}

