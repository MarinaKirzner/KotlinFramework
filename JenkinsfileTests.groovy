def gradleTestTask = "buildTests"

static String startSelectedTestSuite(String gradleTestTask) {
  return """
            echo Start internal test

              gradle $gradleTestTask
              -Dwebdriver.type=remote\\
              -Dwebdriver.browser.name=chrome\\
              -Dwebdriver.browser.headless=true\\
              -Dwebdriver.browser.chrome=100.0.4896.88\\
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