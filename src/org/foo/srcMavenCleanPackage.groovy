package org.foo

class srcMavenCleanPackage {
    void CleanPackage(){
      sh(mvn -B -DskipTests clean package)
    }
    
    
    void run() {
       CleanPackage()
    }
}
