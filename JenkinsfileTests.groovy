static String startSelectedTestSuite() {
  return """
            echo Start internal test
              gradle clean -i test --tests ApplicationPropertiesTest
              
  """
}

pipeline {
  agent any

  tools {
    jdk 'jdk1.8.0_181'
    gradle 'gradle-7.1'
  }

  stages {
    stage('Build Tests') {
      steps {
        bat startSelectedTestSuite()
      }
    }
  }
}