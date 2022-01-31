def buildJar() {
  echo "building the Application..."
  sh 'mvn package'
}

def buildImage() {
  echo 'building the docker image..'
  withCredentials([usernamePassword(credentialsId: 'nexus-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
    sh 'docker build -t 209.97.182.161:8083/my-latest-app:1.0 .'
    sh "echo $PASS | docker login -u $USER --password-stdin 209.97.182.161:8083"
    sh 'docker push 209.97.182.161:8083/my-latest-app:1.0'
  }
}

def deployApp() {
  echo "deploying the Application..."
}

return this
