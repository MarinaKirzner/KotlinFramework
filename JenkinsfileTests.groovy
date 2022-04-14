static String startSelectedTestSuite() {
  return """
            echo Start internal test
              gradle clean -i test --tests ApplicationPropertiesTest
              
  """
}

pipeline {
  agent any

  tools {
    jdk 'jdk8u172'
    gradle 'gradle-7.4.1'
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
      junit 'build/test-results/test/TEST-ApplicationPropertiesTest.xml'
    }
  }
}