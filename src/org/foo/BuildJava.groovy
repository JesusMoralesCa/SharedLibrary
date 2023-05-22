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



class BuildJava {
    String buildName

    BuildJava(String name) {
        this.buildName = name
    }

    def execute() {
        def stageBuild = new Stage(buildName) {
            def process = "mvn -B -DskipTests clean package".execute()
        }
    }
}
