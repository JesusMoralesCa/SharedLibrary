package org.foo

class Stage {

    def createStage(String stageName, String functionName) {
        stage(stageName) {
            steps {
                script {
                    functionName
                }
            }
        }
    }

    def run(String stageName, String functionName) {
        createStage(stageName, functionName)
    }
}
