package org.foo
import org.foo.Stage

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
