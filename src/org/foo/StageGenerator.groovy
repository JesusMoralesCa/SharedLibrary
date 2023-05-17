package org.foo

class StageGenerator {
  static generateStages(config) {
    def stages = []

    config.stages.each { stageConfig ->
      def stageName = stageConfig.stage
      def steps = stageConfig.steps

      def stage = stage(stageName) {
        script{
          for(steps in stageName){
            steps
          }
        }
      }

      stages.add(stage)
    }

    return stages
  }
}
