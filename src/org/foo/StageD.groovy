package org.foo

class Stage {
  String name

  Stage(String name) {
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
