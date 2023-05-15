def call(){
  def file = readProperties file: 'project.properties'
  checkout scmGit(branches: [[name: '*/test']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/pipeline-template.git']])
  if (file['tecnology'] == 'java'){
      def pipelineConfig = readYaml file: 'Java/pipeline.yaml'
          for (stageConfig in pipelineConfig.stages) {
            def stageName = stageConfig.stage
            stage(stageName) {
              for (stepName in stageConfig.steps) {
                // Realizar acciones con el nombre del paso, por ejemplo:
                "${stepName}()"
              }
            }
          }

  }else if (file['tecnology'] == 'node'){
      def pipelineConfig = readYaml file: 'Node/pipeline.yaml'
      for (stageConfig in pipelineConfig.stages) {
            stage(stageConfig.stage) {

        }
      }

  }
}

return this
