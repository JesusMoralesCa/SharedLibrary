package org.foo

class srcMavenCleanPackage {
    
    String script = "sh mvn -B -DskipTests clean package"
    
    void script() {
        script.execute()
        
        
    }
    
    void run() {
        cleanPackage()
    }
}

