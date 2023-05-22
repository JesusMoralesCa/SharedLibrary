package org.foo

class StageGenerator {
    def getStage(String stage) {
        def objectInstance
        String stageClassName

        try {
            stageClassName = "${StageGenerator.class.packageName}.$stage"
            objectInstance = Class.forName(stageClassName, true, Thread.currentThread().contextClassLoader).newInstance()
            
            
            
        } catch (ClassNotFoundException ex) {
            println("No se ha encontrado la stage")
        }
        
        return objectInstance
    } 
}
