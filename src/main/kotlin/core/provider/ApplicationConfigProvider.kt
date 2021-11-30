package core.provider

import core.model.ApplicationConfig

class ApplicationConfigProvider {

  private val filePath = "src/test/resources/dataConfig.yaml"

  fun getDataConfig(): ApplicationConfig {
    return ReadYamlFile.readConfigFile(filePath, ApplicationConfig::class.java)
  }
}