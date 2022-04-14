static String startSelectedTestSuite() {
  return """
            echo Start internal test
              gradle test
  """
}

pipeline {
  agent any
  stages {
    stage('Build Tests') {
      steps {
        bat startSelectedTestSuite()
      }
    }
  }
}