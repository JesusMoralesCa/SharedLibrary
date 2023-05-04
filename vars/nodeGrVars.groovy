def version(){
  sh 'node -version'
}


def test(){
  sh 'echo holaholahola2'
}


def setProperties() {
    def props = readProperties file: 'java.properties'
    env.NODEIMAGE = props['imageNode']
    sh "echo se ha hecho ${env.NODEIMAGE}"
}


def build(){
  sh "docker pull ${env.NODEIMAGE}"
}
