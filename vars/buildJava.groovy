def call(){
  checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/TareaMaven.git']])
  sh "ls"
  packageMVN()
}

def packageMVN(){
  sh "mvn clean package"
  testMVN()
}

def testMVN(){
  sh "mvn test"
  deploy()
}

return this
