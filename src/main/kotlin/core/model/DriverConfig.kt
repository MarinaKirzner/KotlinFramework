package core.model

import core.enum.BrowserType
import core.enum.WebDriverType

data class DriverConfig(
  val timeout: Long,
  val browserScreenSize: String,
  var browserType: BrowserType,
  val webDriverType: WebDriverType,
  val hostRemoteDriver: String,
  val portRemoteDriver: String
)