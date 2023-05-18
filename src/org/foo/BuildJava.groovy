package org.foo
import org.jenkinsci.plugins.pipeline.modeldefinition.model.Stage
import org.jenkinsci.plugins.pipeline.modeldefinition.model.Steps


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
