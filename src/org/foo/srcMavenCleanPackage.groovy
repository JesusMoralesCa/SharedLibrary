package org.foo

class srcMavenCleanPackage {
    
    def script = "mvn -B -DskipTests clean package"

    void cleanPackage() {
        script.sh
    }
    
    void run() {
        cleanPackage()
    }
}

