package org.foo

class srcMavenCleanPackage {
    
    String script = "mvn -B -DskipTests clean package"
    
    void cleanPackage() {
        script.execute()
        
        
    }
    
    void run() {
        cleanPackage()
    }
}

