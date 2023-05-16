import org.foo.*

    
def call() {

    def file = readProperties file: 'project.properties'
    checkout scmGit(branches: [[name: '*/test']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/pipeline-template.git']])
    
    if (file['tecnology'] == 'java') {

        def pipelineConfig = readYaml file: 'Java/pipeline.yaml'
        checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/BuildMaven.git']])
        for (stageConfig in pipelineConfig.stages) {
            def stageName = stageConfig.stage
            stage(stageName) {
             
                
                        script {
                            for (stepName in stageConfig.steps) {
                                def build = new srcMavenCleanPackage()
                                build.run()
                                echo "Se ha ejecutado paso: ${stepName}"
                            }
                        }
                    
                
            }
        }
    } else if (file['tecnology'] == 'node') {
        def pipelineConfig = readYaml file: 'Node/pipeline.yaml'
        
        for (stageConfig in pipelineConfig.stages) {
            stage(stageConfig.stage) {
                
            }
        }
    }
}
return this

