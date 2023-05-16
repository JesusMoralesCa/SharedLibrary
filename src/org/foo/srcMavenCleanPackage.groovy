package org.foo

class srcMavenCleanPackage {
    
    script = "mvn -B -DskipTests clean package"
    Sh sh
    
    void CleanPackage(){
     return script.sh
    }
    
    
    void run() {
       CleanPackage()
    }
}
