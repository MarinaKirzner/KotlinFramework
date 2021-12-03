package core.provider

import core.`object`.TafSystemProperties
import core.model.ApplicationConfig

class ApplicationConfigProvider {

  private val filePath = "src/test/resources/appConfig.yaml"

  fun getApplicationConfig(): ApplicationConfig {

    val applicationConfig: ApplicationConfig = ReadYamlFile.readConfigFile(filePath, ApplicationConfig::class.java)

    System.getProperty(TafSystemProperties.USER)?.let { userSystemProperty ->
      applicationConfig.user = userSystemProperty
    }

    System.getProperty(TafSystemProperties.PASS)?.let { passSystemProperty ->
      applicationConfig.pass = passSystemProperty
    }

    return applicationConfig
  }
}