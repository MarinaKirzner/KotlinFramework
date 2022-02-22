package core.ui.block

import core.ui.element.Link.clickLink
import org.openqa.selenium.By

class CrmClientsTableBlock: BaseLocator() {

  override val baseBlockLocator: By = By.cssSelector("[data-test-id=\"Clients Table\"]")
  private val clientId: String = "//a[text()='%s']"

  fun verifyClientsTableBlock() {
    verifyIsBaseBlockDisplayed()
  }

  fun selectClientIdFromTableBlock(id: String) {
    val crmClientId: By = By.xpath(String.format(clientId, id))
    clickLink(crmClientId)
  }
}