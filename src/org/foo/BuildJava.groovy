package org.foo

class BuildJava{
    String name

    BuilJava(String name){
       this.name = name
    }

    def execute(Closure block){
        sh("mvn clean package")
        block.delegate = this
        block.call()
    }
    
}
