import org.foo.*

def call() {
  def jobs = ["JobA", "JobB", "JobC"]
  
  def parallelStagesMap = new DinamicStage()
  
  parallelStagesMap(jobs)

}
