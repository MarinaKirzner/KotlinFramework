import com.codeborne.selenide.Selenide.closeWebDriver
import core.`object`.Browser.verifyCurrentUrl
import core.`object`.TafSystemProperties
import core.enum.BrowserType
import core.page.LandingPage
import core.provider.DriverConfigSetter
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import step.LandingPageStep

class CalculatorParametriseTest : BaseUiTest() {

  val sum: String = "100"
  val days: String = "7"

  @ParameterizedTest(name = "{arguments}: Verify user registration on the main page in browser")
  @EnumSource(BrowserType::class)
  fun `Verify user registration on the main page in browser`(browserType: BrowserType) {
    System.setProperty(TafSystemProperties.BROWSER_TYPE, browserType.name)
    DriverConfigSetter().setDriverConfig()
    val expectedUrl = "${LandingPage().url}${"/client-area/#/registration?"}"

    LandingPageStep().apply {
      setOpenLandingPage()
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