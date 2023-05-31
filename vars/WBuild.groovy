import org.foo.*


def call() {
    
    checkout scmGit(
        branches: [[name: '*/main']],
        extensions: [],
        userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/pipeline-template.git']]
    )
        def file = readProperties file: 'project.properties'
        def pipelineConfig = readYaml file: "${file['tecnology']}/pipeline.yaml"
        checkout scmGit(
            branches: [[name: '*/main']],
            extensions: [],
            userRemoteConfigs: [[url: "https://github.com/JesusMoralesCa/Build${file['tecnology']}.git"]]
        )
        def stageGenerate = new StageGenerator(this)
        
    for (stageName in pipelineConfig.stages) {
        def stageB = stageGenerate.getStage(stageName.stage.toString(), "${file['tecnology']}")
        stageB.execute(stageName.stage.toString())
    }

    def sonarqubeStage = new SonarqubeStage(this)
    sonarqubeStage.execute("Sonarqube Analisis", "${file['tecnology']}")

}

return this
