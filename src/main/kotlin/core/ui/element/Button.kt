package core.ui.element

import com.codeborne.selenide.Selenide.`$`
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By

object Button {

  private val logger: Logger = LogManager.getLogger()

  fun clickButton(locator: By) {
    logger.info("Click button $locator")
    `$`(locator).click()
  }
}