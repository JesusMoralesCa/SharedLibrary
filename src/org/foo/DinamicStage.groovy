class MyPipelineUtils {
    static def generateParallelStages(jobs) {
        def parallelStagesMap = jobs.collectEntries {
            ["${it}" : generateStage(it)]
        }
        
        return parallelStagesMap
    }
    
    static def generateStage(job) {
        return {
            stage("stage: ${job}") {
                echo "This is ${job}."
                sh script: "sleep 15"
            }
        }
    }
}
