package org.foo

class StageGenerator {
  def generateStages(config) {
        def pipelineConfig = readYaml file: config
        def stages = pipelineConfig.stages
        
        stages.each { stage ->
            stage(stage.stage) {
                steps {
                    stage.steps.each { step ->
                        script {

                            step()
                        }
                    }
                }
            }
        }
    }
}
