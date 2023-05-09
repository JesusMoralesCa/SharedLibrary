def call(){
  credentials('docker-hub-jesusmoralesc')
  sh "docker build -t jesusmoralesc/docker-${env.image} ."
  login()
}

def login(){
     sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
    push()
}

def push(){
  sh "docker push jesusmoralesc/docker-${env.image}"
}

return this
