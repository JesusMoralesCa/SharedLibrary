//////////////////////BUILD///////////////////
def call(){
  def file = readProperties file: 'project.properties'
  if (file['tecnology'] == 'java'){
    nodeGrVars()
    
  }else if (file['tecnology'] == 'node'){
    checkoutNode()
  
  }
}

return this
///////////////////////////////////////////////
