//////////////////////////////////////////////BuildNode

def call(){
  checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/BuildNode.git']])
  installs()
}

def installs(){
  sh "npm install"
  testJest()
}

def testJest(){
  sh "npm install --save jest"
  sh "NODE_OPTIONS=--experimental-vm-modules npx jest"
  build2Node()
}

def build2Node(){
  credentials('docker-hub-jesusmoralesc')
  sh "docker build -t jesusmoralesc/docker-nodejs ."
  login()
  //sh "docker run --name DockerNodeJsApp -p 4000:3000 docker-nodejs"
}

def login(){
     sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
    push()
}

def push(){
  sh 'docker push jesusmoralesc/docker-nodejs'
}

return this
///////////////////////////////////////////////////////
