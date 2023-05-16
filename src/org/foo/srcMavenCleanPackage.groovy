package org.foo

class srcMavenCleanPackage {
    
    String script = "sh mvn -B -DskipTests clean package"
    
    void cleanPackage() {
      sh "mvn -B -DskipTests clean package"
    }
    
    void run() {
        cleanPackage()
    }
}



