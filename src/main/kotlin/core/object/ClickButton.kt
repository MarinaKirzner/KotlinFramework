package core.`object`

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.sleep
import com.codeborne.selenide.Selenide.webdriver
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By

object ClickButton {

  private val logger: Logger = LogManager.getLogger()

  fun clickButton(locator: By) {
    sleep(3000)
    logger.info("Click button $locator")
    `$`(locator).also { element ->
      element.shouldBe(Condition.visible).click()
    }
  }
}
