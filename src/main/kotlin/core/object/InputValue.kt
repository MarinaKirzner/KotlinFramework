package core.`object`

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.sleep
import com.codeborne.selenide.Selenide.webdriver
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By
import org.openqa.selenium.Keys

object InputValue {

  private val logger: Logger = LogManager.getLogger()

  fun setInputValue(locator: By, value: String) {
    sleep(3000)
    logger.info("Set $value in input field")
    `$`(locator).also { element ->
      element.shouldBe(Condition.visible).sendKeys(Keys.CONTROL, "a")
      element.sendKeys(value)
    }
  }
}