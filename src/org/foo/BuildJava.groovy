package org.foo

class BuildJava {
    def buildStage(String stageName, String command) {
        def stage = new Stage()
        stage.setName(stageName)
        
        def steps = new Steps()
        steps.sh("mvn -B -DskipTests clean package")
        stage.setSteps(steps)
        
        return stage
    }
}
