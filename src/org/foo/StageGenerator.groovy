package org.foo

class StageGenerator {

    def script
    StageGenerator(script) {
        this.script = script
    }
    def getStage(String stage) {
        def objectInstance
        def stageClassName

        try {
            stageClassName = "${StageGenerator.class.packageName}.$stage"
            this.echo("ClassName: ${stageClassName}")
            objectInstance = Class.forName(stageClassName, true, Thread.currentThread().contextClassLoader).newInstance()
            
            
            
        } catch (ClassNotFoundException ex) {
            this.echo("No se ha encontrado la stage")
        }
        
        return objectInstance
    } 
}
