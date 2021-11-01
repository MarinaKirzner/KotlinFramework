package config.provider

import config.factory.ReadConfigFile
import config.factory.ReadJsonConfig
import config.factory.ReadYamlConfig
import config.model.Config
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class ConfigProvider {

  companion object {
    private val logger: Logger = LogManager.getRootLogger()
    private const val CONFIG_FILE_PATH = "src/test/resources/config/taf_config"
  }

  fun getConfig(formatType: FormatType): Config {
    logger.info("Selected factory for read config file")
    val configFile: ReadConfigFile = when (formatType) {
      FormatType.JSON -> ReadJsonConfig()
      FormatType.YAML -> ReadYamlConfig()
    }
    logger.info("Factory selected")
    return configFile.readConfigFile(CONFIG_FILE_PATH)
  }
}
