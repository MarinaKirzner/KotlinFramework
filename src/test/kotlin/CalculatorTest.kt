import core.`object`.Browser.verifyCurrentUrl
import core.provider.DriverConfigSetter
import org.junit.jupiter.api.Test
import step.LandingPageSteps

class CalculatorTest : BaseUiTest() {

  val sum: String = "100"
  val days: String = "7"
  val registrationUrl = RegistrationPage().getPageUrl()

  @Test
  fun `Submit Landing Page calculator values and verify redirect on Registration Page`() {
    val expectedUrl = registrationUrl
    DriverConfigSetter().setDriverConfig()
    LandingPageSteps().apply {
      openLandingPage()
      clickAcceptCookies()
      fillCalculator(sum, days)
      clickRequestRegistration()
    }
    verifyCurrentUrl(expectedUrl)
  }
}