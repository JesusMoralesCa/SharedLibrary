@Grab('org.yaml:snakeyaml:1.17')

import org.yaml.snakeyaml.Yaml
import org.foo.StageGenerator

    
def call() {

    def file = readProperties file: 'project.properties'
    checkout scmGit(branches: [[name: '*/test']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/pipeline-template.git']])
    
    if (file['tecnology'] == 'java') {

            def yamlRead = readYaml file: 'Java/pipeline.yaml'
            Yaml parser = new Yaml()
            List pipelineConfig = parser.load(yamlRead)

        
        
        checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/BuildMaven.git']])
        def stages = new StageGenerator()
        stages.generateStages(pipelineConfig)
        
    } else if (file['tecnology'] == 'node') {
        def pipelineConfig = readYaml file: 'Node/pipeline.yaml'
        
        for (stageConfig in pipelineConfig.stages) {
            stage(stageConfig.stage) {
                
            }
        }
    }
}
return this

