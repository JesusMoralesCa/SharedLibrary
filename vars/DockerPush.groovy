def call(){
  sh "docker push jesusmoralesc/docker-${env.image}"
}

return this
