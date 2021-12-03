package step

import core.page.LandingPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class LandingPageSteps {

  private val landingPage: LandingPage by lazy { LandingPage() }

  fun openLandingPage() {
    landingPage.openPage()
  }

  fun clickAcceptCookies() {
    landingPage.acceptCookies()
  }

  fun fillCalculator(sum: String, days: String) {
    landingPage.apply {
      creditAmount(sum)
      loanDays(days)
    }
  }

  fun clickRequestRegistration() {
    landingPage.requestRegistration()
  }
}