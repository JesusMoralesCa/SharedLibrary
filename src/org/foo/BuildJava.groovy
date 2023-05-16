package org.foo

class BuildJava {
  
  

  
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
