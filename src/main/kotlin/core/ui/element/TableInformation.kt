package core.ui.element

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.SelenideElement
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By

object TableInformation {

  private val logger: Logger = LogManager.getLogger()
  private val rowLocator: By = By.xpath("tbody/tr")
  private val headerCellLocator: By = By.xpath("th")
  private val valueCellLocator: By = By.xpath("td")

  private fun findCellTextValue(rowElement: SelenideElement, cellLocator: By): String {
    return rowElement.find(cellLocator).text
  }

  fun getTableValues(rowsTable: By): Map<String, String> {
    logger.info("Get information from table")
    val rowsCollection: ElementsCollection = `$`(rowsTable).`$$`(rowLocator)
    return rowsCollection.associateBy(
      { findCellTextValue(it, headerCellLocator) }, { findCellTextValue(it, valueCellLocator) }
    )
  }
}