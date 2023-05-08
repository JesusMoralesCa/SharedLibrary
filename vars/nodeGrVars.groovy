def test(){
  sh 'echo holaholahola2'
}
 


//////////////////////BUILD///////////////////
def build(){
  def file = readProperties file: 'project.properties'
  if (file['tecnology'] == 'java'){
    buildJava()
    
  }else if (file['tecnology'] == 'node'){
    checkoutNode()
  
  }
}
///////////////////////////////////////////////





//////////////////////////////////////////////BuildNode

def checkoutNode(){
  checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/BuildNode.git']])
  installs()
}

def installs(){
  sh "npm install"
  testJest()
}

def build2Node(){
  credentials('docker-hub-jesusmoralesc')
  sh "docker build -t docker-nodejs ."
  login()
  //sh "docker run --name DockerNodeJsApp -p 4000:3000 docker-nodejs"
  //testJest()
}

def login(){
  sh "docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin"
  push()
}

def push(){
  sh 'docker push docker-nodejs'
}

def testJest(){
  sh "npm install --save jest"
  sh "NODE_OPTIONS=--experimental-vm-modules npx jest"
}



///////////////////////////////////////////////////////7







///NODE
def buildNode(){
  def props2 = readProperties file: 'node.properties'
  env.NODEIMAGE = props2['imageNode']
  sh "echo se ha hecho ${env.NODEIMAGE}"
  sh "docker pull ${env.NODEIMAGE}"
  sh "docker build -t ${env.NODEIMAGE}:ImageNode -f DockerF/Node/Dockerfile ."
  //sh "docker run -d -p 3000:3000 ImageNode"
}

///JAVA
def buildJava(){
  def props = readProperties file: 'java.properties'
  env.JAVAIMAGE = props['imageJava']
  sh "echo se ha hecho ${env.JAVAIMAGE}"
  sh "docker pull ${env.JAVAIMAGE}"
  sh "docker build -t ${env.NODEIMAGE}:ImageJava -f DockerF/Java/Dockerfile ."
}


