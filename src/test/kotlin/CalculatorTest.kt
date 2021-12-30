import core.ui.driver.setter.DriverConfigSetter
import core.ui.element.Browser.verifyCurrentUrl
import core.ui.page.RegistrationPage
import org.junit.jupiter.api.Test
import step.LandingPageSteps

class CalculatorTest : BaseTest() {

  private val sum: String = "100"
  private val days: String = "7"

  @Test
  fun `Submit Landing Page calculator values and verify redirect on Registration Page`() {
    DriverConfigSetter().setDriverConfig()
    LandingPageSteps().apply {
      openLandingPage()
      clickAcceptCookies()
      fillCalculator(sum, days)
      clickRequestRegistration()
    }
    verifyCurrentUrl(RegistrationPage().registrationUrl)
  }
}