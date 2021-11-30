import core.`object`.Browser.verifyUrl
import core.model.ApplicationConfig
import core.page.LandingPage
import core.provider.ApplicationConfigProvider
import core.provider.DriverProvider
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CalculatorTest {

  private val applicationConfig: ApplicationConfig = ApplicationConfigProvider().getDataConfig()
  val url: String = "https://${applicationConfig.user}:${applicationConfig.pass}@${applicationConfig.host}${"/client-area/#/registration?"}"
  val sum: String = "100"
  val days: String = "7"

  @BeforeEach
  fun setup() {
    DriverProvider().getDriverConfig()
    LandingPage().apply {
      openPage()
      clickAcceptCookies()
    }
  }

  @Test
  fun `Checking user registration on the main page`() {
    LandingPage().apply {
      setCreditAmount(sum)
      setLoanDays(days)
      requestRegistration()
    }
    verifyUrl(url)
  }
}