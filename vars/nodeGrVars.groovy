def test(){
  sh 'echo holaholahola2'
}
 

def build(){
  def props2 = readProperties file: 'node.properties'
  env.NODEIMAGE = props2['imageNode']
  sh "echo se ha hecho ${env.NODEIMAGE}"
  sh "docker pull ${env.NODEIMAGE}"
  sh "docker build -t ${env.NODEIMAGE}:ImageNode -f DockerF/Dockerfile ."
  
  test()
  
  //sh "docker run -d -p 3000:3000 ImageNode"
}
