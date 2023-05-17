package org.foo
import groovy.yaml.YamlSlurper

class StageGenerator {
  def generateStages(config) {
        def yaml = new YamlSlurper().parse(new File(yamlPath).text)
        def stages = yaml.stages
        
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
