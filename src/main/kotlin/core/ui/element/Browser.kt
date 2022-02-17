package core.ui.element

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.webdriver
import com.codeborne.selenide.WebDriverConditions.url
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By

object Browser {

  private val logger: Logger = LogManager.getLogger()

  fun verifyCurrentUrl(url: String) {
    logger.info("Verify registration URL - $url")
    webdriver().shouldHave(url(url))
  }

  fun verifyElementIsVisible(element: By) {
    logger.info("Verify element from page is visible - $element")
    `$`(element).shouldBe(Condition.visible)
  }
}