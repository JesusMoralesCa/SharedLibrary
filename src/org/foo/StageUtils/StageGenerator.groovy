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
                    if (!objectInstance) {
                        stageClassName = "org.foo.Stages.$stage.$stage"
                        objectInstance = Class.forName(stageClassName, true, Thread.currentThread().contextClassLoader).newInstance()

                    }
            objectInstance.script = script

        } catch (ClassNotFoundException ex) {
            script.echo("No se ha encontrado la stage")
        }



        return objectInstance
    } 
}
