package config.factory

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import com.fasterxml.jackson.module.kotlin.readValue
import config.model.Config
import config.provider.FormatType
import java.io.File

class ReadYamlConfig : ReadConfigFile {
  override fun readConfigFile(filePath: String): Config {
    val mapper = YAMLMapper()
    val file = File("$filePath${FormatType.YAML.path}")
    return mapper.readValue(file)
  }
}