package org.foo

class StageGenerator {
  def generateStages(config) {
        
        def stages = config.stages
    return{
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
  
  
  
  
  
}
