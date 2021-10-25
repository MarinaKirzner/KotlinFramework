package config

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper
import com.fasterxml.jackson.module.kotlin.readValue
import data_class.ConfigFile
import enum.FormatType
import java.io.File

class ReadYamlConfig: ReadConfigFile {
  override fun readConfigFile(): ConfigFile {
    val mapper = YAMLMapper()
    val file = File(FormatType.YAML.path)
    return mapper.readValue(file)
  }
}