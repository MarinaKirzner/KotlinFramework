package core.`object`

import com.codeborne.selenide.Selenide.webdriver
import com.codeborne.selenide.WebDriverConditions.url
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object Browser {

  private val logger: Logger = LogManager.getLogger()

  fun verifyUrl(url: String) {
    webdriver().shouldHave(url(url))
    logger.info("Verify registration URL")
  }
}