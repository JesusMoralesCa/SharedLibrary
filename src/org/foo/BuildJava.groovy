package org.foo
import org.foo.Stage

class BuildJava{
    String name
    
     BuildJava(String name){
       this.name = name
    }
    void build() {
        def stage = new Stage(name) {
            def process = "mvn -B -DskipTests clean package".execute()
            process.waitFor()

            if (process.exitValue() == 0) {
                println "El proceso de construcción se completó exitosamente."
            } else {
                println "Ocurrió un error durante el proceso de construcción."
            }
        }
    }
}
