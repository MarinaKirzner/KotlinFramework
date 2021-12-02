package core.provider

import core.`object`.TafSystemProperties
import core.model.ApplicationConfig

class ApplicationConfigProvider {

  private val filePath = "src/test/resources/appConfig.yaml"

  private var userStr: String? = System.getProperty(TafSystemProperties.USER)
  private var passStr: String? = System.getProperty(TafSystemProperties.PASS)

  fun getApplicationConfig(): ApplicationConfig {

    val applicationConfig: ApplicationConfig = ReadYamlFile.readConfigFile(filePath, ApplicationConfig::class.java)

    when {
      userStr != null || passStr != null -> {
        applicationConfig.user = userStr!!
        applicationConfig.pass = passStr!!
      }
    }

    return applicationConfig
  }
}