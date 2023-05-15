import org.foo.*

def call() {
    def file = readProperties file: 'project.properties'
    checkout scmGit(branches: [[name: '*/test']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/pipeline-template.git']])
    
    if (file['technology'] == 'java') {
        def pipelineConfig = readYaml file: 'Java/pipeline.yaml'
        
        for (stageConfig in pipelineConfig.stages) {
            def stageName = stageConfig.stage
            stage(stageName) {
                for (stepName in stageConfig.steps) {
                    def build = new BuildJava()
                    build.stepName()
                }
            }
        }
    } else if (file['technology'] == 'node') {
        def pipelineConfig = readYaml file: 'Node/pipeline.yaml'
        
        for (stageConfig in pipelineConfig.stages) {
            stage(stageConfig.stage) {
                
            }
        }
    }
}
return this

