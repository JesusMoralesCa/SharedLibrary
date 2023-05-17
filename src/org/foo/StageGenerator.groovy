package org.foo

class StageGenerator {
  static generateStages(config) {
    def stages = []

    config.stages.each { stageConfig ->
      def stageName = stageConfig.stage
      def steps = stageConfig.steps

      def stage = new CustomStage(stageName, steps)
      stages.add(stage)
    }

    return stages
  }
}

class CustomStage extends Stage {
  CustomStage(def script, IContext context, Map config) {
    super(script, context, config)
    STAGE_NAME = config.stage
  }

  protected run() {
    // Implementa aquí la lógica específica de la etapa
    // Ejecuta los pasos correspondientes
    steps.each { step ->
      executeStep(step)
    }
  }

  protected executeStep(step) {
    // Implementa aquí la lógica para ejecutar el paso específico
    println "Executing step: $step"
    // ...
  }
}
