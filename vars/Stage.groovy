import org.foo.*

def call() {
  def jobs = ["JobA", "JobB", "JobC"]
  
 def parallelStagesMap = DinamicStage.generateParallelStages(jobs)
  
  parallelStagesMap

}
return this
