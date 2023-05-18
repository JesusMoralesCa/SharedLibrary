package org.foo

class StageGenerator {
    def getStage(String stage) {
        def objectInstance
        def stageClassName

        try {
            stageClassName = "${StageGenerator.class.packageName}.$stage"
            objectInstance = Class.forName(stageClassName, true, Thread.currentThread().contextClassLoader).newInstance()
        } catch (ClassNotFoundException ex) {
            println("No se ha encontrado la stage")
        }
        return objectInstance
    }
    
    
def generateStage(stageGenerate, stageName) {
  def stage = stageGenerate.getStage(stageName.stage.toString())
    
        stage(stageName) {
            step {
                if (stage) {
                    stage.script()
                }
            }
        }
    }

    
}
