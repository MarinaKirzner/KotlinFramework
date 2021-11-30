package core.provider

import core.model.DriverConfig

class DriverConfigProvider {

  private val filePath = "src/test/resources/defaultDriverConfig.yaml"

  fun getDriverConfig(): DriverConfig {
    return ReadYamlFile.readConfigFile(filePath, DriverConfig::class.java)
  }
}