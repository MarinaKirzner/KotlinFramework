package config

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import data_class.ConfigFile
import enum.FormatType
import java.io.File

class ReadJsonConfig : ReadConfigFile {
  override fun readConfigFile(): ConfigFile {
    val mapper = jacksonObjectMapper()
    val file = File(FormatType.JSON.path)
    return mapper.readValue(file)
  }
}