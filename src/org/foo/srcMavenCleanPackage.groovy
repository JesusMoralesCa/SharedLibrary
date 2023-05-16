package org.foo

class srcMavenCleanPackage {
    void CleanPackage(){
     return mvn -B -DskipTests clean package
    }
    
    
    void run() {
       CleanPackage()
    }
}
