def call(){
  sh "npm install --save jest"
  sh "NODE_OPTIONS=--experimental-vm-modules npx jest"
}

return this
