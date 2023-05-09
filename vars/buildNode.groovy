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

return this
///////////////////////////////////////////////////////
