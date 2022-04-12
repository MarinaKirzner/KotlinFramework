pipeline {
  stages {
    stage('Build Tests') {
      steps {
         sh 'make'
      }
    }
  }
}