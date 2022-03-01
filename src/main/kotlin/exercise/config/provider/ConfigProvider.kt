package exercise.config.provider

import exercise.config.factory.ReadConfigFile
import exercise.config.factory.ReadJsonConfig
import exercise.config.factory.ReadYamlConfig
import exercise.config.model.Config
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class ConfigProvider {

  companion object {
    private val logger: Logger = LogManager.getLogger()
    private const val CONFIG_FILE_PATH = "src/test/resources/exercise.config/taf_config"
  }

  fun getConfig(formatType: FormatType): Config {
    logger.info("Selected exercise.factory for read exercise.config file")
    val configFile: ReadConfigFile = when (formatType) {
      FormatType.JSON -> ReadJsonConfig()
      FormatType.YAML -> ReadYamlConfig()
    }
    return configFile.readConfigFile(CONFIG_FILE_PATH)
  }
}