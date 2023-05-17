package org.foo

class StageGenerator {
  static generateStages(config) {
    def stages = []

    for (stageConfig in config.stages) {
      def stageName = stageConfig.stage
      def steps = stageConfig.steps

      def stage = createStage(stageName, steps)

      stages.add(stage)
    }

    return stages
  }

  static createStage(stageName, steps) {
    stage(stageName) {
      steps.each { step ->
        // Ejecutar la acción correspondiente al nombre del paso
        // Aquí puedes hacer lo que sea necesario con step
        // Por ejemplo:
        // echo "Ejecutando paso: $step"
      }
    }
  }
}
