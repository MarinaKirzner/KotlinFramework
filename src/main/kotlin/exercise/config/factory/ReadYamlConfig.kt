package exercise.config.factory

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import exercise.config.model.Config
import exercise.config.provider.FormatType
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.io.File

class ReadYamlConfig : ReadConfigFile {

  companion object {
    val logger: Logger = LogManager.getLogger()
  }

  override fun readConfigFile(filePath: String): Config {
    val mapper = ObjectMapper(YAMLFactory()).registerModule(KotlinModule())
    val file = File("$filePath${FormatType.YAML.path}")
    logger.info("Selected Yaml exercise.config file")
    return mapper.readValue(file)
  }
}