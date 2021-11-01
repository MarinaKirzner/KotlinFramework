package config.factory

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import config.model.Config
import config.provider.FormatType
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.io.File

class ReadYamlConfig : ReadConfigFile {

  companion object {
    val logger: Logger = LogManager.getRootLogger()
  }

  override fun readConfigFile(filePath: String): Config {
    val mapper = ObjectMapper(YAMLFactory()).registerModule(KotlinModule())
    val file = File("$filePath${FormatType.YAML.path}")
    logger.info("Selected Yaml config file")
    return mapper.readValue(file)
  }
}