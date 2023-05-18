package org.foo

class BuildJava {
    def buildStage(String stageName) {
        def stage = [:]
        stage.name = stageName
        
        def steps = []
        steps.add([
            sh: "mvn -B -DskipTests clean package"
        ])
        stage.steps = steps
        
        return stage
    }
}
