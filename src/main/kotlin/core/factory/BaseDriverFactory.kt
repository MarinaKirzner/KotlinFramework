package core.factory

import com.codeborne.selenide.Configuration.browser
import com.codeborne.selenide.Configuration.browserSize
import com.codeborne.selenide.Configuration.timeout
import core.model.DriverConfig

abstract class BaseDriverFactory : ReadConfig {

  override fun setConfig(driverConfig: DriverConfig) {
    apply{
      timeout = driverConfig.timeout
      browserSize = driverConfig.browserScreenSize
      browser = driverConfig.browserType
    }
  }
}