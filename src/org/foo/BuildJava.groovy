package org.foo

class BuildJava {
    def buildStage(def stage) {
        def steps = []
        steps.add([
            sh: "mvn -B -DskipTests clean package"
        ])
        stage.steps = steps
        
        stage.buildStage() // Llama a la función buildStage() en el objeto stage
        
        return stage
    }
}
