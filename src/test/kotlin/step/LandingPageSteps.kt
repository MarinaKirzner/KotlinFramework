package step

import core.page.LandingPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class LandingPageSteps {

  private val logger: Logger = LogManager.getLogger()
  private val landingPage: LandingPage by lazy { LandingPage() }

  fun openLandingPage() {
    logger.info("Open landing page - http://qa-delivery-es-release.moneyman.ru")
    landingPage.openPage()
  }

  fun clickAcceptCookies() {
    logger.info("Click accept cookies")
    landingPage.acceptCookies()
  }

  fun fillCalculator(sum: String, days: String) {
    logger.info("Fill calculator form")
    landingPage.apply {
      creditAmount(sum)
      loanDays(days)
    }
  }

  fun clickRequestRegistration() {
    logger.info("Click button to registration")
    landingPage.requestRegistration()
  }
}