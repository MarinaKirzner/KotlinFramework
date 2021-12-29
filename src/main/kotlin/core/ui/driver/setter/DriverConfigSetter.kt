package core.ui.driver.setter

import core.ui.driver.BrowserType.CHROME
import core.ui.driver.BrowserType.FIREFOX
import core.ui.driver.WebDriverType
import core.ui.driver.factory.BaseDriverFactory
import core.ui.driver.factory.ChromeDriverFactory
import core.ui.driver.factory.FireFoxDriverFactory
import core.ui.driver.factory.RemoteDriverFactory
import core.ui.driver.model.DriverConfig
import core.ui.driver.provider.DriverConfigProvider

class DriverConfigSetter {

  val driverConfig: DriverConfig = DriverConfigProvider().getDriverConfig()

  fun setDriverConfig() {
    val driverFactory: BaseDriverFactory = when (driverConfig.webDriverType) {
      WebDriverType.LOCAL -> {
        when (driverConfig.browserType) {
          CHROME -> ChromeDriverFactory()
          FIREFOX -> FireFoxDriverFactory()
        }
      }
      WebDriverType.REMOTE -> RemoteDriverFactory()
    }
    return driverFactory.setConfig(driverConfig)
  }
}