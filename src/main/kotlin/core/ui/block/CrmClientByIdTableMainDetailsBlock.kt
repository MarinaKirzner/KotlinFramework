package core.ui.block

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.`$`
import core.ui.element.TableInformation.clientInformationFromTable
import org.openqa.selenium.By

class CrmClientByIdTableMainDetailsBlock : BaseLocator() {

  override val baseBlockLocator: By = By.xpath("//h4[text()='Общая информация']/ancestor::table/descendant::tbody")
  private val parameterMainTable: By = By.cssSelector("th:nth-child(n)")
  private val detailsMainTable: By = By.cssSelector("td:nth-child(n)")

  fun verifyClientIdTableBlock() {
    verifyIsBaseBlockDisplayed()
  }

  fun selectClientIdDetailsFromTableBlock() {
    val cellParameterTable: ElementsCollection = `$`(baseBlockLocator).`$$`(parameterMainTable)
    val cellParameterValueTable: ElementsCollection = `$`(baseBlockLocator).`$$`(detailsMainTable)
    clientInformationFromTable(cellParameterTable, cellParameterValueTable)
  }
}