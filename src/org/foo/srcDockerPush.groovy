package org.foo

    def script() {
        sh "docker push jesusmoralesc/docker-${env.image}"
    }
    
return this
