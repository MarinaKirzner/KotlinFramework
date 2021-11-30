package core.factory

import com.codeborne.selenide.Configuration.remote
import core.model.DriverConfig
import io.github.bonigarcia.wdm.WebDriverManager

class RemoteDriverFactory() : BaseDriverFactory() {

  override fun setConfig(driverConfig: DriverConfig) {
    remote = "${driverConfig.hostRemoteDriver}:${driverConfig.portRemoteDriver}"
    super.setConfig(driverConfig)
    WebDriverManager.getInstance().setup()
  }
}