def call(){
  sh "docker push jesusmoralesc/docker-${file['imageName']}"
}

return this
