package core.provider

import core.enum.BrowserType.CHROME
import core.enum.BrowserType.FIREFOX
import core.enum.WebDriverType
import core.factory.BaseDriverFactory
import core.factory.ChromeDriverFactory
import core.factory.FireFoxDriverFactory
import core.factory.RemoteDriverFactory
import core.model.DriverConfig

class DriverConfigProvider {

  val driverConfig: DriverConfig = ReadDriverConfigProvider().getDriverConfig()

  fun getDriverConfig() {
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