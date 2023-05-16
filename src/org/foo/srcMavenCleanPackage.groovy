package org.foo

class srcMavenCleanPackage {
    void echo(){
        sh "sh "mvn -B -DskipTests clean package"
    }
    
    
    void run() {
       echo()
    }
}
