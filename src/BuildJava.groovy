package org.foo

class BuildJava {
  
  
  def WBuild(){
    def file = readProperties file: 'project.properties'
    checkout scmGit(branches: [[name: '*/test']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/pipeline-template.git']])
    
    if (file['technology'] == 'java') {
        def pipelineConfig = readYaml file: 'Java/pipeline.yaml'
        
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
  
  
  def srcCheckout(){
    checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/BuildMaven.git']])
  }
  
  def srcMavenCleanPackage(){
    sh "mvn -B -DskipTests clean package"
  }
  
  def srcMavenTest(){
    sh "mvn test"
  }

  def srcDockerBuild(){
    credentials('docker-hub-jesusmoralesc')
    sh "docker build -t jesusmoralesc/docker-${env.image} ."
  }

}
