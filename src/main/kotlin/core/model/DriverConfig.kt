package core.model

data class DriverConfig(
  val timeout: Long,
  val browserScreenSize: String,
  val browserType: String,
  val webDriverType: String
)