package org.foo


  def generateStages(config) {
        
        def stages = config.stages
        stages.each { stage ->
            stage(stage.stage) {
                steps {
                    stage.steps.each { //step ->
                        script {

                           // step()
                        }
                    }
                }
            }
        }
  }


return this
