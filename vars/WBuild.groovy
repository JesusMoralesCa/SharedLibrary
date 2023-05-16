def call() {
    
    sh "echo se esta haciendo"
    def file = readProperties file: 'project.properties'
    
    if (file['technology'] == 'java') {
        checkout scmGit(branches: [[name: '*/test']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/pipeline-template.git']])
        def pipelineConfig = readYaml file: 'Java/pipeline.yaml'
        sh "echo se esta haciendo2"
        for (stageConfig in pipelineConfig.stages) {
            def stageName = stageConfig.stage
            stage(stageName) {
                for (stepName in stageConfig.steps) {
                    //def build = new BuildJava()
                    build."${stepName}"()
                    echo "Ejecutando paso: ${stepName}"
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

