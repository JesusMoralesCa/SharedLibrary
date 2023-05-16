package org.foo

class srcMavenCleanPackage {
    
    String script = "mvn -B -DskipTests clean package"
    
    void cleanPackage() {
        def process = script.execute()
        process.waitFor()
        
    }
    
    void run() {
        cleanPackage()
    }
}

