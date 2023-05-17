package org.foo

class StageGenerator {
  static generateStages(config) {
    def stages = []

    config.stages.each { stageConfig ->
      def stageName = stageConfig.stage
      def steps = stageConfig.steps

      def stage = stage(stageName) {
        script {
          steps.each { step ->
            // Llamar a la función según el nombre del paso
            this."$step"()
          }
        }
      }

      stages.add(stage)
    }

    return stages
  }
}
