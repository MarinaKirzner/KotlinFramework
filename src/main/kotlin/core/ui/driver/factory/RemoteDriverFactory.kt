package core.ui.driver.factory

import com.codeborne.selenide.Configuration.remote
import core.ui.driver.model.DriverConfig

class RemoteDriverFactory() : BaseDriverFactory() {

  override fun setConfig(driverConfig: DriverConfig) {
    remote = "${driverConfig.hostRemoteDriver}:${driverConfig.portRemoteDriver}"
    super.setConfig(driverConfig)
  }
}