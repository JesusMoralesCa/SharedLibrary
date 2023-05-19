import org.foo.*

def call() {
  def jobs = ["JobA", "JobB", "JobC"]
  
 def parallelStagesMap = DinamicStage.generateParallelStages(jobs)
  
  parallel parallelStagesMap

}
return this
