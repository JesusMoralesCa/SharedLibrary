def call(){
  installs()
}

def installs(){
  sh "npm install"
  testJest()
}

def testJest(){
  sh "npm install --save jest"
  sh "NODE_OPTIONS=--experimental-vm-modules npx jest"
  deploy()
}

return this
