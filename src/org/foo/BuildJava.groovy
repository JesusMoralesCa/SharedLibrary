package org.foo

class BuildJava{
        def execute() {
        sh "mvn -B -DskipTests clean package"
    }
}

