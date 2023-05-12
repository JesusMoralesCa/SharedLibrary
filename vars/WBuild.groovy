def call(){
  def file = readProperties file: 'project.properties'
  checkout scmGit(branches: [[name: '*/test']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/pipeline-template.git']])
  if (file['tecnology'] == 'java'){
      def pipelineConfig = readYaml(file: 'Java/pipeline.yaml')
          pipelineConfig.each { stage ->
            stage(stage.key) {
              steps {
                stage.value.steps.each { step ->
                  // Agregar pasos de la etapa según los valores de 'step'
                }
              }
            }
          }

  }else if (file['tecnology'] == 'node'){
    load 'Node/pipeline.yaml'

  }
}

return this
