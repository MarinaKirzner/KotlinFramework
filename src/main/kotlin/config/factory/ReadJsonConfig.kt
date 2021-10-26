package config.factory

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import config.model.Config
import enum.FormatType
import java.io.File

class ReadJsonConfig : ReadConfigFile {
  override fun readConfigFile(filePath: String): Config {
    val mapper = jacksonObjectMapper()
    val file = File("$filePath${FormatType.JSON.path}")
    return mapper.readValue(file)
  }
}