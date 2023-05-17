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

    void run(String stageName, String stepCode) {
        createStage(stageName) {
            steps {
                script {
                    evaluate(stepCode)
                }
            }
        }
    }
}
