package org.foo

class BuildJava {
    def steps = [] // Agrega la propiedad steps y asigna un valor inicial vacío

    def setSteps(List steps) {
        this.steps = steps
    }

    def getSteps() {
        return steps
    }

    def buildStage(def stage) {
        // Aquí puedes usar la propiedad steps como desees
        // Por ejemplo, puedes agregar elementos a la lista de steps
        steps.add([
            sh: "mvn -B -DskipTests clean package"
        ])

        

        return stage
    }
}
