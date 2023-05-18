package org.foo
@Grab('org.jenkins-ci.plugins:pipeline-model-definition:1.8.4')
@Grab('org.jenkins-ci.plugins:workflow-basic-steps:2.23')
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
