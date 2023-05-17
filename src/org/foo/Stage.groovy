package org.foo

import groovy.lang.Closure

class Stage {

    def createStage(String stageName, Closure fun) {
        stage(stageName) {
            steps {
                script {
                    fun.call()
                }
            }
        }
    }

    void run(String stageName, Closure fun) {
        createStage(stageName, fun)
    }
}
