package core.ui.block

import core.ui.element.Button.clickButton
import core.ui.element.Dropdown.setDropdownValue
import org.openqa.selenium.By

class CrmClientsFilterBlock : BaseBlock() {

  override val baseBlockLocator: By = By.cssSelector("form[data-test-id='Clients Filter']")
  private val crmClientTypeDropdownLocator: By = By.id("TYPE")
  private val crmSearchButtonLocator: By = By.cssSelector("[type='submit']")

  fun selectClientTypeByFilterBlock(valueClientType: String) {
    setDropdownValue(crmClientTypeDropdownLocator, valueClientType)
  }

  fun clickSearchButtonByFilterBlock() {
    clickButton(crmSearchButtonLocator)
  }
}