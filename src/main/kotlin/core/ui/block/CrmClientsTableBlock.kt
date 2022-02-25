package core.ui.block

import org.openqa.selenium.By

class CrmClientsTableBlock : BaseBlock() {

  override val baseBlockLocator: By = By.cssSelector("[data-test-id='Clients Table']")
}