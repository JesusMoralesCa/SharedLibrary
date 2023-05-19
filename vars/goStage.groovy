import org.foo.*

def call() {
  def createStage = new Stage()

  def stages = [
    new createStage('Stage 1'),
    new createStage('Stage 2')
  ]

  for (stage in stages) {
    stage.execute()
  }

  return this
}
