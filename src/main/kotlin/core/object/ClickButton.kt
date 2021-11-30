package core.`object`

import com.codeborne.selenide.Selenide.sleep
import com.codeborne.selenide.Selenide.webdriver
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By

object ClickButton {

  private val logger: Logger = LogManager.getLogger()

  fun clickButton(element: By) {

    sleep(3000)
    webdriver().driver().webDriver.findElement(element).click()
    logger.info("Click button $element")
  }
}
