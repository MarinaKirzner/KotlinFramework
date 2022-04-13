@Library('shared_libs@CI_CD_shared_libs')

def gradleTestTask = "internalTest"

static String startSelectedTestSuite(String gradleTestTask) {
  return """
            echo Start internal test
            gradle $gradleTestTask
  """
}

pipeline {
  stages {
    stage('Build Tests') {
      steps {
        sh startSelectedTestSuite(gradleTestTask)
      }
    }
  }
}