package core.ui.block

import org.openqa.selenium.By

class CrmClientsSearchResultsBlock : BaseBlock() {

  override val baseBlockLocator: By = By.cssSelector("[data-test-id='Clients Table']")
}