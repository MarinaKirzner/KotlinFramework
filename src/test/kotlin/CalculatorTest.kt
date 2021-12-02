import core.`object`.Browser.verifyCurrentUrl
import core.holder.StaticContextHolder.applicationConfig
import core.provider.DriverConfigSetter
import org.junit.jupiter.api.Test
import step.LandingPageStep

class CalculatorTest : BaseUiTest() {

  val sum: String = "100"
  val days: String = "7"

  @Test
  fun `Verify user registration on the main page`() {
    val url: String =
      "https://${applicationConfig?.user}:${applicationConfig?.pass}@${applicationConfig?.host}${"/client-area/#/registration?"}"
    DriverConfigSetter().setDriverConfig()
    LandingPageStep().apply {
      setOpenLandingPage()
      clickAcceptCookies()
      fillCalculator(sum, days)
      clickRequestRegistration()
    }
    verifyCurrentUrl(url)
  }
}