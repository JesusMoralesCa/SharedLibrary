//////////////////////BUILD///////////////////
def build(){
  def file = readProperties file: 'project.properties'
  if (file['tecnology'] == 'java'){
    checkoutJava()
    
  }else if (file['tecnology'] == 'node'){
    checkoutNode()
  
  }
}
///////////////////////////////////////////////
