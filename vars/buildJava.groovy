def call(){
  packageMVN()
}

def packageMVN(){
  sh "mvn clean package"
  testMVN()
}

def testMVN(){
  sh "mvn test"
  deploy()
}

return this
