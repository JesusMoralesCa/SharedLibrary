//////////////////////BUILD///////////////////
def call(){
  def file = readProperties file: 'project.properties'
  if (file['tecnology'] == 'java'){
    Java()
    
  }else if (file['tecnology'] == 'node'){
    Node()
  
  }
}

return this
///////////////////////////////////////////////
