package org.foo

class srcMavenCleanPackage {
    
    String script = "mvn -B -DskipTests clean package"
    def sh
    
    void cleanPackage() {
        sh(script)
    }
    
    void run() {
        cleanPackage()
    }
}

