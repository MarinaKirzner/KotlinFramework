package core.provider

import core.`object`.TafSystemProperties
import core.enum.BrowserType
import core.model.DriverConfig

class DriverConfigProvider {

  private val filePath = "src/test/resources/defaultDriverConfig.yaml"

  fun getDriverConfig(): DriverConfig {
    val driverConfig: DriverConfig = ReadYamlFile.readConfigFile(filePath, DriverConfig::class.java)
    System.getProperty(TafSystemProperties.BROWSER_TYPE)?.let { browserTypeSystemProperty ->
      driverConfig.browserType = BrowserType.valueOf(browserTypeSystemProperty)
    }
    return driverConfig
  }
}