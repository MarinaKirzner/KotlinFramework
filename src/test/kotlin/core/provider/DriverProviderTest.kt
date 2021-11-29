package core.provider


import com.codeborne.selenide.Selenide.sleep
import core.model.DataConfig
import core.page.LandingPage
import core.page.RegistrationPage
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class DriverProviderTest {

  @BeforeEach
  fun setup() {
    DriverConfigProvider().setDriverConfig()
    LandingPage().apply {
      openPage()
      acceptCookies()
    }
    sleep(3000)
  }

  @Test
  fun `Checking user registration on the main page`() {
    LandingPage().apply {
      creditAmount("100")
      loanDays("7")
      requestRegistration()
    }

    RegistrationPage().verifyPageUrl()
  }
}
