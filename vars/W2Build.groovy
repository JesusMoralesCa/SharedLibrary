//////////////////////BUILD///////////////////
def call(){
  def file = readProperties file: 'project.properties'
  if (file['tecnology'] == 'java'){
    buildJava()
    
  }else if (file['tecnology'] == 'node'){
    buildNode()
  
  }
}

return this
///////////////////////////////////////////////
