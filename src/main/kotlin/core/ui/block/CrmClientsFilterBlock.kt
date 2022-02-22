package core.ui.block

import core.ui.element.Button.clickButton
import core.ui.element.Dropdown.setDropdownValue
import org.openqa.selenium.By

class CrmClientsFilterBlock: BaseLocator() {

  override val baseBlockLocator: By = By.cssSelector("form[data-test-id='Clients Filter']")
  private val crmClientTypeByDropdown: By = By.id("TYPE")
  private val crmSearchButton: By = By.cssSelector("[type='submit']")

  fun verifyFilterByClientsBlock() {
    verifyIsBaseBlockDisplayed()
  }

  fun selectClientTypeInFilterBlock(valueClientType: String) {
    setDropdownValue(crmClientTypeByDropdown, valueClientType)
    clickButton(crmSearchButton)
  }
}