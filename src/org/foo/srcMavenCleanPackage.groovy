package org.foo

class srcMavenCleanPackage {
    
    String script = "sh mvn -B -DskipTests clean package"
    
    void cleanPackage() {
        script.execute()
        
        
    }
    
    void run() {
        cleanPackage()
    }
}

