package core.provider

import core.`object`.TafSystemProperties
import core.model.ApplicationConfig

class ApplicationConfigProvider {

  private val filePath = "src/test/resources/appConfig.yaml"
  private val applicationConfig: ApplicationConfig =
    ReadYamlFile.readConfigFile(filePath, ApplicationConfig::class.java)

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