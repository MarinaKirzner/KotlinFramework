package core.factory

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Configuration.browser
import com.codeborne.selenide.Configuration.browserSize
import com.codeborne.selenide.Configuration.timeout
import core.model.DriverConfig

abstract class BaseDriverFactory : DriverFactory {

  override fun setConfig(driverConfig: DriverConfig) {
    Configuration().apply {
      timeout = driverConfig.timeout
      browserSize = driverConfig.browserScreenSize
      browser = driverConfig.browserType.toString()
    }
  }
}