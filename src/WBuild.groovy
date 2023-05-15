def call(){
  def file = readProperties file: 'project.properties'
  checkout scmGit(branches: [[name: '*/test']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/pipeline-template.git']])
  if (file['tecnology'] == 'java'){
      def pipelineConfig = readYaml file: 'Java/pipeline.yaml'
      for (stageConfig in pipelineConfig.stages) {
            stage(stageConfig.stage) {

        }
      }
         
  


  }else if (file['tecnology'] == 'node'){
      def pipelineConfig = readYaml file: 'Java/pipeline.yaml'
      for (stageConfig in pipelineConfig.stages) {
            stage(stageConfig.stage) {

        }
      }

  }
}

return this