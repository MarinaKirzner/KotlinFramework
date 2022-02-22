package core.ui.element

import com.codeborne.selenide.Selenide.`$`
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By

object Dropdown {

  private val logger: Logger = LogManager.getLogger()

  fun setDropdownValue(dropdownValue: By, value: String) {
    logger.info("Select in dropdown $value")
    `$`(dropdownValue).selectOptionContainingText(value)
  }
}