package core.ui.block

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.`$`
import core.ui.element.TableInformation.getInformationFromTable
import org.openqa.selenium.By

class CrmClientMainDetailsBlock : BaseBlock() {

  override val baseBlockLocator: By = By.xpath("//h4[text()='Общая информация']/ancestor::table")
  private val rowLocator: By = By.xpath("tbody/tr")
  private val rowsTable: ElementsCollection = `$`(baseBlockLocator).`$$`(rowLocator)

  fun getClientIdMainDetailsFromTable(): Map<String, String> {
    return getInformationFromTable(rowsTable)
  }
}