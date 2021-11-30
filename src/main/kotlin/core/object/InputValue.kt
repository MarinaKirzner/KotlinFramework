package core.`object`

import com.codeborne.selenide.Selenide.sleep
import com.codeborne.selenide.Selenide.webdriver
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By
import org.openqa.selenium.Keys

object InputValue {

  private val logger: Logger = LogManager.getLogger()

  fun setInputValue(element: By, value: String) {
    sleep(3000)
    webdriver().driver().webDriver.findElement(element).sendKeys(Keys.CONTROL, "a")
    webdriver().driver().webDriver.findElement(element).sendKeys(value)
    logger.info("Set $value in input field")
  }
}