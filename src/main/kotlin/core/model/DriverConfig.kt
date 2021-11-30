package core.model

import core.enum.BrowserType
import core.enum.WebDriverType

data class DriverConfig(
  val timeout: Long,
  val browserScreenSize: String,
  val browserType: BrowserType,
  val webDriverType: WebDriverType,
  val hostRemoteDriver: String,
  val portRemoteDriver: String
)