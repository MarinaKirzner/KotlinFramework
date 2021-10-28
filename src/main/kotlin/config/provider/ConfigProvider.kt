package config.provider

import config.factory.ReadConfigFile
import config.factory.ReadJsonConfig
import config.factory.ReadYamlConfig
import config.model.Config

class ConfigProvider {
  companion object {
    private const val CONFIG_FILE_PATH = "src/test/resources/config/taf_config"
  }

  fun getConfig(formatType: FormatType): Config {
    val configFile: ReadConfigFile = when (formatType) {
      FormatType.JSON -> ReadJsonConfig()
      FormatType.YAML -> ReadYamlConfig()
    }
    return configFile.readConfigFile(CONFIG_FILE_PATH)
  }
}
