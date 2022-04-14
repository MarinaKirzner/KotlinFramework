static String startSelectedTestSuite() {
  return """
            echo Start internal test
              gradle clean -i test --tests ApplicationPropertiesTest
              
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

  post {
    always {
      junit 'build/test-results/**/*.xml'
    }
  }

//  post {
//    always {
//      archiveArtifacts artifacts: '**/*.jar', fingerprint: true
//      junit 'build/test-results/**/*.xml'
//    }
//  }
}