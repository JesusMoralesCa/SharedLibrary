package org.foo

class srcMavenCleanPackage {
    
    String script = "mvn -B -DskipTests clean package"
    
    void cleanPackage() {
        def result = sh(script)
        
        if (result == 0) {
            println "El comando se ejecutó correctamente."
        } else {
            println "Error al ejecutar el comando."
        }
    }
    
    void run() {
        cleanPackage()
    }
}

