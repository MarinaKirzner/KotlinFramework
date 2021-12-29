package core.context.constant

import core.reader.YamlFileReader
import core.taf_property.TafSystemProperties

class ApplicationConfigProvider {

  private val filePath = "src/test/resources/appConfig.yaml"
  private val applicationConfig: ApplicationConfig =
    YamlFileReader.readConfigFile(filePath, ApplicationConfig::class.java)

  fun getApplicationConfig(): ApplicationConfig {
    System.getProperty(TafSystemProperties.USER)?.let { userSystemProperty ->
      applicationConfig.user = userSystemProperty
    }
    System.getProperty(TafSystemProperties.PASS)?.let { passSystemProperty ->
      applicationConfig.pass = passSystemProperty
    }
    return applicationConfig
  }
}