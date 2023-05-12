def call(){
  def file = readProperties file: 'project.properties'
  checkout scmGit(branches: [[name: '*/test']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/pipeline-template.git']])
  if (file['tecnology'] == 'java'){
    def pipelineYaml = readFile 'Java/pipeline.yaml'
    def pipeline = readYaml pipelineYaml


  }else if (file['tecnology'] == 'node'){
    load 'Node/pipeline.yaml'

  }
}

return this
