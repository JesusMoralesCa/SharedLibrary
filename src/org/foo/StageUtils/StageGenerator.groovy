package org.foo.StageUtils

class StageGenerator {

    def script
    StageGenerator(script) {
        this.script = script
    }


    def getStage(String stage, String Technology) {
        def objectInstance
        def stageClassName

        try {
            stageClassName = "${StageGenerator.class.packageName}.$stage.$stage$Technology"

            script.echo("ClassName: ${stageClassName}")
            objectInstance = Class.forName(stageClassName, true, Thread.currentThread().contextClassLoader).newInstance()
            objectInstance.script = script
            
            
        } catch (ClassNotFoundException ex) {
            script.echo("No se ha encontrado la stage")
        }

        if (!objectInstance) {
            
            try {
                stageClassName = "${StageFactory.class.packageName}.$stage.$stage"
                objectInstance = Class.forName(stageClassName, true, Thread.currentThread().contextClassLoader)
            } catch (ClassNotFoundException ex) {
                print("WARN: Is not possible to get the needed Stage")
            }
        }

        
        return objectInstance
    } 
}
