package core.ui.driver.provider

import core.reader.YamlFileReader
import core.taf_property.TafSystemProperties
import core.ui.driver.BrowserType
import core.ui.driver.model.DriverConfig

class DriverConfigProvider {

  private val filePath = "src/test/resources/defaultDriverConfig.yaml"

  fun getDriverConfig(): DriverConfig {
    val driverConfig: DriverConfig = YamlFileReader.readConfigFile(filePath, DriverConfig::class.java)
    System.getProperty(TafSystemProperties.BROWSER_TYPE)?.let { browserTypeSystemProperty ->
      driverConfig.browserType = BrowserType.valueOf(browserTypeSystemProperty)
    }
    return driverConfig
  }
}