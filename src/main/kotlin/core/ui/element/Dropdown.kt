package core.ui.element

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By

object Dropdown {

  private val logger: Logger = LogManager.getLogger()

  fun setValueInDropdown(valueInDropdown: By, value: String) {
    logger.info("Select in dropdown $value")
    `$`(valueInDropdown).also { element ->
      element.shouldBe(Condition.visible)
      element.selectOptionContainingText(value)
    }
  }
}