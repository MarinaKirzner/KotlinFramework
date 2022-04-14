def gradleTestTask = "buildTests"

static String startSelectedTestSuite(String gradleTestTask) {
  return """
            echo Start internal test
              gradle $gradleTestTask
  """
}

pipeline {
  agent any
  stages {
    stage('Build Tests') {
      steps {
        bat startSelectedTestSuite(gradleTestTask)
      }
    }
  }
}