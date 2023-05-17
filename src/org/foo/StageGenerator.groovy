package org.foo

class StageGenerator {
  static generateStages(config) {
    def stages = []
    
    
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
