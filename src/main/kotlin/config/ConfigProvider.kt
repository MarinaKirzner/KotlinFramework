package config

import data_class.ConfigFile
import enum.FormatType

class ConfigProvider {
  fun getConfig(formatType: FormatType): ConfigFile {
    return when (formatType) {
      FormatType.JSON -> ReadJsonConfig().readConfigFile()
      FormatType.YAML -> ReadYamlConfig().readConfigFile()
    }
  }
}
