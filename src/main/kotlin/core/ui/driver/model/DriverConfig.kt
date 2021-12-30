package core.ui.driver.model

import core.ui.driver.BrowserType
import core.ui.driver.WebDriverType

data class DriverConfig(
  val timeout: Long,
  val browserScreenSize: String,
  var browserType: BrowserType,
  val webDriverType: WebDriverType,
  val hostRemoteDriver: String,
  val portRemoteDriver: String
)