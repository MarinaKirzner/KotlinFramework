package core.factory

import core.model.DriverConfig
import io.github.bonigarcia.wdm.WebDriverManager

class ChromeDriverFactory : BaseDriverFactory() {

  override fun setConfig(driverConfig: DriverConfig) {
    super.setConfig(driverConfig)
    WebDriverManager.chromedriver().setup()
  }
}