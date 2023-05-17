package org.foo

class stage {
    
    def stage(string stageName, string fun){

        stage(stageName){
            steps{
                script{
                    fun
                }
            }
        }
    }

        
    void run(stageName,fun) {
       return stage(stageName,fun)
    }
}
