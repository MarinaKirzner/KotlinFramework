import core.`object`.Browser.verifyCurrentUrl
import core.holder.StaticContextHolder.applicationConfig
import core.provider.DriverConfigSetter
import org.junit.jupiter.api.Test
import step.LandingPageSteps

class CalculatorTest : BaseUiTest() {

  val sum: String = "100"
  val days: String = "7"

  @Test
  fun `Submit Landing Page calculator values and verify redirect on Registration Page`() {
    val url: String =
      "https://${applicationConfig?.user}:${applicationConfig?.pass}@${applicationConfig?.host}${"/client-area/#/registration?"}"
    DriverConfigSetter().setDriverConfig()
    LandingPageSteps().apply {
      openLandingPage()
      clickAcceptCookies()
      fillCalculator(sum, days)
      clickRequestRegistration()
    }
    verifyCurrentUrl(url)
  }
}