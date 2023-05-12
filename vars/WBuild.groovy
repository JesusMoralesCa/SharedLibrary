def call(){
  def file = readProperties file: 'project.properties'
  checkout scmGit(branches: [[name: '*/test']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/pipeline-template.git']])
  if (file['tecnology'] == 'java'){
         load 'Java/pipeline.yaml'


  }else if (file['tecnology'] == 'node'){
    load 'Node/pipeline.yaml'

  }
}

return this
