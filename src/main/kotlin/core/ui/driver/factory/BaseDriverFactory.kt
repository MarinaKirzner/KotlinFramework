package core.ui.driver.factory

import com.codeborne.selenide.Configuration.browser
import com.codeborne.selenide.Configuration.browserSize
import com.codeborne.selenide.Configuration.timeout
import core.ui.driver.model.DriverConfig

abstract class BaseDriverFactory : DriverFactory {

  override fun setConfig(driverConfig: DriverConfig) {
    timeout = driverConfig.timeout
    browserSize = driverConfig.browserScreenSize
    browser = driverConfig.browserType.toString()
  }
}