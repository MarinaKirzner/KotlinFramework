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

  fun getHostUrl(): String {
    val host = "https://${applicationConfig.host}"
    return host
  }

  fun getUrlRegistration(): String {
    val host = "https://${applicationConfig.host}${applicationConfig.registrationUrl}"
    return host
  }

  fun getUrlWithAuthentication(): String {
    val urlWithAuthentication = "https://${applicationConfig.user}" +
        ":${applicationConfig.pass}" +
        "@${applicationConfig.host}"
    return urlWithAuthentication
  }

  fun getEndPointUrlWithAuthentication(): String {
    val urlRegistrationEndpoint = "https://${applicationConfig.user}" +
        ":${applicationConfig.pass}" +
        "@${applicationConfig.host}" +
        "${applicationConfig.registrationEndPoint}"
    return urlRegistrationEndpoint
  }
}