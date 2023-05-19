package org.foo

class Stage {
  String name

  Stage(String name) {
    this.name = name
  }

  def execute(Closure body) {
    stage(name) {
      steps {
        script {
          body.call()
        }
      }
    }
  }
}
