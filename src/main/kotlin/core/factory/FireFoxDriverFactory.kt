package core.factory

import core.model.DriverConfig
import io.github.bonigarcia.wdm.WebDriverManager

class FireFoxDriverFactory : BaseDriverFactory() {

  override fun setConfig(driverConfig: DriverConfig) {
    super.setConfig(driverConfig)
    WebDriverManager.firefoxdriver().setup()
  }
}