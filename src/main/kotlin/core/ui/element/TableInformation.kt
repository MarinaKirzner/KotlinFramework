package core.ui.element

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.`$`
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By

object TableInformation {

  private val logger: Logger = LogManager.getLogger()
  private val rowLocator: By = By.xpath("tbody/tr")
  private val headerCellLocator: By = By.xpath("th")
  private val valueCellLocator: By = By.xpath("td")

  fun getTableValues(rowsTable: By): Map<String, String> {
    logger.info("Get information from table")
    val rowsCollection: ElementsCollection = `$`(rowsTable).`$$`(rowLocator)
    val tableInformation: MutableMap<String, String> = mutableMapOf()
    for (i in 0 until rowsCollection.size) {
      tableInformation[rowsCollection[i].find(headerCellLocator).text] = rowsCollection[i].find(valueCellLocator).text
    }
    return tableInformation
  }
}