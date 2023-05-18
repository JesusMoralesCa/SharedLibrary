package org.foo


def generateStages(List config) {
    config.each { stage ->
        stage(stage.stage) {
            steps {
                stage.steps.each { step ->
                    script {
                        step.call()
                    }
                }
            }
        }
    }
}


return this
