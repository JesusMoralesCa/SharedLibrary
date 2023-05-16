package org.foo

class srcMavenCleanPackage {
    
    String script = "sh mvn -B -DskipTests clean package"
    
    void script() {
      def process = script.execute()
        process.waitFor()
        
        if (process.exitValue() == 0) {
            println "El comando se ejecutó correctamente."
        } else {
            println "Error al ejecutar el comando."
        }
    }
    
    void run() {
        cleanPackage()
    }
}

