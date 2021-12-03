package step

import core.page.LandingPage
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

class LandingPageSteps : LandingPage() {

  private val logger: Logger = LogManager.getLogger()

  fun openLandingPage() {
    logger.info("Open landing page - http://qa-delivery-es-release.moneyman.ru")
    openPage()
  }

  fun clickAcceptCookies() {
    logger.info("Click accept cookies")
    acceptCookies()
  }

  fun fillCalculator(sum: String, days: String) {
    logger.info("Fill calculator form")
    creditAmount(sum)
    loanDays(days)
  }

  fun clickRequestRegistration() {
    logger.info("Click button to registration")
    requestRegistration()
  }
}