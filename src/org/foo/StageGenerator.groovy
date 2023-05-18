package org.foo


def generateStages(List config) {
    def stages = config.stages
    stages.each { stage ->
        stage(stage) {
            steps {
                stage.steps.each { step ->
                    script {
                        step.call() // Llama a la función step
                    }
                }
            }
        }
    }
}


return this
