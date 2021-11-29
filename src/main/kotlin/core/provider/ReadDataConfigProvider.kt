package core.provider

import core.model.DataConfig

class ReadDataConfigProvider {

  private val filePath = "src/test/resources/dataConfig.yaml"

  fun getDataConfig(): DataConfig {
    return ReadYamlFile.readConfigFile(filePath, DataConfig::class.java)
  }
}