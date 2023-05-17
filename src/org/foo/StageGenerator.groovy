package org.foo

class StageGenerator {
  def generateStagesFromYaml(config) {
        //def yaml = new YamlSlurper().parse(new File(yamlPath).text)
        def stages = config.stages
        
        stages.each { stage ->
            stage(stage.stage) {
                steps {
                    stage.steps.each { step ->
                        script {
                            // Llamada a las funciones definidas en tu repositorio de librerías
                            // Puedes hacer referencia a la carpeta "src" como `src`
                            // Ejemplo: src.MavenCleanPackage()
                            step()
                        }
                    }
                }
            }
        }
    }
}
