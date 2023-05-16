package org.foo

class srcMavenCleanPackage {
    
    script = "mvn -B -DskipTests clean package"
    
    void CleanPackage(){
     return script
    }
    
    
    void run() {
       CleanPackage()
    }
}
