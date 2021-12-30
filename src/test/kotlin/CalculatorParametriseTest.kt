import com.codeborne.selenide.Selenide.closeWebDriver
import core.taf_property.TafSystemProperties
import core.ui.driver.BrowserType
import core.ui.driver.setter.DriverConfigSetter
import core.ui.element.Browser.verifyCurrentUrl
import core.ui.page.RegistrationPage
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import step.LandingPageSteps

class CalculatorParametriseTest : BaseTest() {

  private val sum: String = "100"
  private val days: String = "7"

  @ParameterizedTest(
    name = "{arguments}: Submit Landing Page calculator values and Verify redirect on Registration " +
        "Page in browser"
  )
  @EnumSource(BrowserType::class)
  fun `Submit the landing page calculator values and check the redirection on the registration page in browsers`(
    browserType: BrowserType
  ) {
    System.setProperty(TafSystemProperties.BROWSER_TYPE, browserType.name)
    DriverConfigSetter().setDriverConfig()
    LandingPageSteps().apply {
      openLandingPage()
      clickAcceptCookies()
      fillCalculator(sum, days)
      clickRequestRegistration()
    }
    verifyCurrentUrl(RegistrationPage().registrationUrl)
  }

  @AfterEach
  fun clearDriver() {
    System.clearProperty(TafSystemProperties.BROWSER_TYPE)
    closeWebDriver()
  }
}