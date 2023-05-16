package org.foo

class srcMavenCleanPackage {
    void CleanPackage(){
        mvn -B -DskipTests clean package
    }
    
    
    void run() {
       CleanPackage()
    }
}
