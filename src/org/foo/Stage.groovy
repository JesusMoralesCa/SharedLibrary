package org.foo

class Stage {
  String name

  Stage(String name, Closure body) {
    this.name = name
  }

  def execute() {
    stage(name) {
      steps {
        script {
          sh 'mvn clean install' // Paso 'mvn clean install'
        }
      }
    }
  }
}
