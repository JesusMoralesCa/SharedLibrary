import org.foo.*

def call() {

    checkout scmGit(
        branches: [[name: '*/main']],
        extensions: [],
        userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/Java-Node.git']]
    )
        SonarqubeStage sonarqubeStage = new SonarqubeStage(this)
        sonarqubeStage.execute("Sonarqube Analisis")
}

return this
