package config.factory

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import config.model.Config
import config.provider.FormatType
import java.io.File

class ReadYamlConfig : ReadConfigFile {
  override fun readConfigFile(filePath: String): Config {
    val mapper = ObjectMapper(YAMLFactory()).registerModule(KotlinModule())
    val file = File("$filePath${FormatType.YAML.path}")
    return mapper.readValue(file)
  }
}