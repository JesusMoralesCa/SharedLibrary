import org.foo.*

def call() {
    def file = readProperties file: 'project.properties'
    checkout scmGit(
        branches: [[name: '*/test']],
        extensions: [],
        userRemoteConfigs: [[url: 'https://github.com/JesusMoralesCa/pipeline-template.git']]
    )

    //def file2 = readProperties file: 'sonar-project.properties'
    def sonarqube = new SonarqubeStage(this)
    sonarqube.execute("Stage Sonarqube", file2)
    
        def pipelineConfig = readYaml file: "${file['tecnology']}/pipeline.yaml"
        checkout scmGit(
            branches: [[name: '*/main']],
            extensions: [],
            userRemoteConfigs: [[url: "https://github.com/JesusMoralesCa/Build${file['tecnology']}.git"]]
        )
        def stageGenerate = new StageGenerator(this)
        
        for (stageName in pipelineConfig.stages) {
            def stageB = stageGenerate.getStage(stageName.stage.toString())
            stageB.execute(stageName.stage.toString())
        }
}

return this
