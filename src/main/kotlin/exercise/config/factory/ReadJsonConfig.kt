package exercise.config.factory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import exercise.config.model.Config
import exercise.config.provider.FormatType
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import java.io.File

class ReadJsonConfig : ReadConfigFile {

  companion object {
    private val logger: Logger = LogManager.getLogger()
  }

  override fun readConfigFile(filePath: String): Config {
    val mapper = jacksonObjectMapper()
    val file = File("$filePath${FormatType.JSON.path}")
    logger.info("Selected Json exercise.config file")
    return mapper.readValue(file)
  }
}