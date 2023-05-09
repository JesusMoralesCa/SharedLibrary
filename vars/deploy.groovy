def call(){
  def file = readProperties file: 'project.properties'
  credentials('docker-hub-jesusmoralesc')
  sh "docker build -t jesusmoralesc/docker-${file['imageName']} ."
  login()
}

def login(){
     sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
    push()
}

def push(){
  sh "docker push jesusmoralesc/docker-${file['imageName']}"
}

return this
