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
            stageClassName = "org.foo.Stages.$stage.$stage$Technology"

            script.echo("ClassName: ${stageClassName}")
            objectInstance = Class.forName(stageClassName, true, Thread.currentThread().contextClassLoader).newInstance()
            objectInstance.script = script

            if (!objectInstance.exists) {
            
                try {
                    stageClassName = "org.foo.Stages.$stage.$stage"
                    objectInstance = Class.forName(stageClassName, true, Thread.currentThread().contextClassLoader)
                    objectInstance.script = script
            } catch (ClassNotFoundException ex) {
                    script.echo("No se ha encontrado la stage por segunda vez")
                }
            }
            
        } catch (ClassNotFoundException ex) {
            script.echo("No se ha encontrado la stage")
        }

        return objectInstance
    } 
}
