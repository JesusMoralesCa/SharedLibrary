package org.foo

    def script() {
         credentials('docker-hub-jesusmoralesc')
         sh "docker build -t jesusmoralesc/docker-${env.image} ."
    }
    
return this
