static String startSelectedTestSuite() {
  return """
            echo Start internal test
              gradle clean tests
              
  """
}

pipeline {
  agent any

  tools {
    jdk 'jdk1.8'
    gradle 'gradle'
  }

  stages {
    stage('Build Tests') {
      steps {
        bat startSelectedTestSuite()
      }
    }
  }

  post {
    always {
      archiveArtifacts artifacts: '**/*.jar', fingerprint: true
      junit 'build/test-results/**/*.xml'
    }
  }
}