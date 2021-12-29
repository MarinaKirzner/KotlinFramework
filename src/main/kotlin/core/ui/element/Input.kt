package core.ui.element

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By
import org.openqa.selenium.Keys

object Input {

  private val logger: Logger = LogManager.getLogger()

  fun setInputValue(locator: By, value: String) {
    logger.info("Set $value in input field")
    `$`(locator).also { element ->
      element.shouldBe(Condition.visible).sendKeys(Keys.CONTROL, "a")
      element.sendKeys(value)
    }
  }
}