package org.foo

class StageGenerator {
  static generateStages(config) {
    def stages = []
    
    config.stage.each { stageConfig ->
      def stageName = stageConfig.stage
      def steps = stageConfig.steps

      def stage = createStage(stageName, steps)

      stages.add(stage)
    }

    return stages
  }

  static createStage(stageName, steps) {
      steps.each { step ->
        step
        
      }
    }
 
}
