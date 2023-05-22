package org.foo
//import org.foo.Stage


class Stage {
    String name

    Stage(String name, Closure body) {
        this.name = name
        body.delegate = this
        body.call()
    }
}

class BuildJava{
    String name
    
     BuildJava(String name){
       this.name = name
    }
    void build() {
        def stageBuild = new Stage(name) {
            def process = "mvn -B -DskipTests clean package".execute()
        }
    }
}
