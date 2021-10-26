package config.provider

import config.model.Config
import config.factory.ReadJsonConfig
import config.factory.ReadYamlConfig
import enum.FormatType

class ConfigProvider {
  private val configFilePath = "src/test/resources/config/taf_config"
  fun getConfig(formatType: FormatType): Config {
    return when (formatType) {
      FormatType.JSON -> ReadJsonConfig().readConfigFile(configFilePath)
      FormatType.YAML -> ReadYamlConfig().readConfigFile(configFilePath)
    }
  }
}
