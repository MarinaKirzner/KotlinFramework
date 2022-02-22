package core.ui.element

import com.codeborne.selenide.Selenide.`$`
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By

object Link {

  private val logger: Logger = LogManager.getLogger()

  fun clickLink(locator: By) {
    logger.info("Click link $locator")
    `$`(locator).click()
  }
}