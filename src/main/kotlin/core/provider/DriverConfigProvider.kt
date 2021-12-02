package core.provider

import core.`object`.TafSystemProperties
import core.enum.BrowserType
import core.model.DriverConfig

class DriverConfigProvider {

  private val filePath = "src/test/resources/defaultDriverConfig.yaml"

  private var driverTypeStr: String? = System.getProperty(TafSystemProperties.BROWSER_TYPE)
  private val browserType: BrowserType? = driverTypeStr?.let { BrowserType.valueOf(it) }

  fun getDriverConfig(): DriverConfig {

    val driverConfig: DriverConfig = ReadYamlFile.readConfigFile(filePath, DriverConfig::class.java)

    if (driverTypeStr != null) {
      driverConfig.browserType = browserType!!
    }
    return driverConfig
  }
}