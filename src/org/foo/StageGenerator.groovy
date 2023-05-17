package org.foo

class StageGenerator {
  static generateStages(config) {
    def stages = []

    config.stages.each { stageConfig ->
      def stageName = stageConfig.stage
      def steps = stageConfig.steps

      def stage = createStage(stageName, steps)

      stages.add(stage)
    }

    return stages
  }

  static createStage(stageName, steps) {
    return { context, logger ->
      logger.info("Running stage: $stageName")

      steps.each { step ->
        // Ejecutar el paso específico de la etapa
        executeStep(step)
      }
    }
  }

  static executeStep(step) {
    // Implementar la lógica para ejecutar el paso específico
    println "Executing step: $step"
    // ...
  }
}
