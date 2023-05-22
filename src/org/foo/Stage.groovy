package org.foo

class Stage {
  String name

  Stage(String name, Closure body) {
    this.name = name
    body.delegate = this
    body.call()
  }
}
