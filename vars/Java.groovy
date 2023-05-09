def call(){
  checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/TareaMaven.git']])
  package()
}

def packageMVN(){
  sh "mvn clean package"
  testMVN()
}

def testMVN(){
  sh "mvn test"
  
}

def build2Java(){
  credentials('docker-hub-jesusmoralesc')
  sh "docker build -t jesusmoralesc/docker-javaMVN ."
  login()
}

def login(){
     sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
    push()
}

def push(){
  sh 'docker push jesusmoralesc/docker-javaMVN'
}

return this
