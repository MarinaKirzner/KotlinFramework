package core.factory

import com.codeborne.selenide.Configuration.remote
import core.model.DriverConfig

class RemoteDriverFactory() : BaseDriverFactory() {

  override fun setConfig(driverConfig: DriverConfig) {
    remote = "${driverConfig.hostRemoteDriver}:${driverConfig.portRemoteDriver}"
    super.setConfig(driverConfig)
  }
}