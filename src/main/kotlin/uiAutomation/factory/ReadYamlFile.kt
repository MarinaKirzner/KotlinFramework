package uiAutomation.factory

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory
import com.fasterxml.jackson.module.kotlin.KotlinModule
import com.fasterxml.jackson.module.kotlin.readValue
import uiAutomation.enum.FormatType
import uiAutomation.model.Config
import java.io.File

class ReadYamlFile : ReadConfigFile {
  companion object {
    private const val CONFIG_FILE_PATH = "src/test/resources/defaultWebDriverConfig"
  }

  override fun readConfigFile(): String {
    val mapper = ObjectMapper(YAMLFactory()).registerModule(KotlinModule())
    val file = File("$CONFIG_FILE_PATH${FormatType.YAML.path}")
    return mapper.readValue<Config>(file).browserType
  }
}
