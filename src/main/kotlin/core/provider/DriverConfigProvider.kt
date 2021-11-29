package core.provider

import core.enum.BrowserType.CHROME
import core.enum.BrowserType.FIREFOX
import core.factory.ChromeDriverFactory
import core.factory.FireFoxDriverFactory
import core.model.DriverConfig

class DriverConfigProvider {

  val config: DriverConfig = ReadDriverConfigProvider().getDriverConfig()

  fun setDriverConfig() {

    when (config.browserType) {
      CHROME.name -> ChromeDriverFactory().setConfig(config)
      FIREFOX.name -> FireFoxDriverFactory().setConfig(config)
    }
  }
}