def test(){
  sh 'echo holaholahola2'
}
 


//////////////////////BUILD///////////////////
def build(){
  def file = readProperties file: 'project.properties'
  if (file['tecnology'] == 'java'){
    buildJava()
    
  }else if (file['tecnology'] == 'node'){
    buildNode()
  
  }
}
///////////////////////////////////////////////


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


