package core.provider

import com.codeborne.selenide.Selenide.sleep
import core.`object`.Browser
import core.model.DataConfig
import core.page.LandingPage
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DriverProviderTest {

  private val dataConfig: DataConfig = ReadDataConfigProvider().getDataConfig()
  val url: String = "https://${dataConfig.user}:${dataConfig.pass}@${dataConfig.host}${"/client-area/#/registration?"}"
  val sum: String = "100"
  val days: String = "7"

  @BeforeEach
  fun setup() {
    DriverConfigProvider().getDriverConfig()
    LandingPage().apply {
      openPage()
      acceptCookies()
    }
    sleep(3000)
  }

  @Test
  fun `Checking user registration on the main page`() {
    LandingPage().apply {
      creditAmount(sum)
      loanDays(days)
      requestRegistration()
    }
    Browser.verifyUrl(url)
  }
}
