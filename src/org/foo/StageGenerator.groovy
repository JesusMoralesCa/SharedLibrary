package org.foo

class StageGenerator {
  static generateStages(config) {
    def stage = []
    
    
      for (stageConfig in config.stages) {
        stage(stageConfig.stage) {
          script{
            for(step in config.steps){
              step
            }
          }
        stages.add(stage)
        }
  
    return stages
  }
 }
}
