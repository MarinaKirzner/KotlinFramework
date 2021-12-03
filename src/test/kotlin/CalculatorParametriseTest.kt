import com.codeborne.selenide.Selenide.closeWebDriver
import core.`object`.Browser.verifyCurrentUrl
import core.`object`.TafSystemProperties
import core.enum.BrowserType
import core.provider.DriverConfigSetter
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import step.LandingPageSteps

class CalculatorParametriseTest : BaseUiTest() {

  val sum: String = "100"
  val days: String = "7"
  val expectedUrl = RegistrationPage().getPageUrl()

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
    verifyCurrentUrl(expectedUrl)
  }

  @AfterEach
  fun clearDriver() {
    System.clearProperty(TafSystemProperties.BROWSER_TYPE)
    closeWebDriver()
  }
}