package core.ui.block

import core.ui.element.TableInformation.getTableValues
import org.openqa.selenium.By

class CrmClientMainDetailsBlock : BaseBlock() {

  override val baseBlockLocator: By = By.xpath("//h4[text()='Общая информация']/ancestor::table")

  fun getClientMainDetailsFromTable(): Map<String, String> {
    return getTableValues(baseBlockLocator)
  }
}