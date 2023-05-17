package org.foo
import groovy.yaml.Yaml

class StageGenerator {
  def generateStages(config) {
        def yaml = new Yaml().parseText(yamlContent)
        def stages = yaml.stages
        
        stage.each { stage ->
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
