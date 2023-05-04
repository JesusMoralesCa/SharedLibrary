def version(){
  sh 'node -version'
}


def test(){
  sh 'echo holaholahola2'
}


def setProperties() {
    def props2 = readProperties file: 'node.properties'
    env.NODEIMAGE = props2['imageNode']
    sh "echo se ha hecho ${env.NODEIMAGE}"
}


def build(){
  sh "docker pull ${env.NODEIMAGE}"
}
