package core.ui.element

import com.codeborne.selenide.ElementsCollection
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By

object TableInformation {

  private val logger: Logger = LogManager.getLogger()

  fun getInformationFromTable(rowLocator: ElementsCollection): Map<String, String> {
    logger.info("Get information from table")
    val headerCellLocator: By = By.xpath("th")
    val valueCellLocator: By = By.xpath("td")

    val tableInformation: MutableMap<String, String> = mutableMapOf()
    for (i in 0 until rowLocator.size) {
      tableInformation[rowLocator[i].find(headerCellLocator).text] = rowLocator[i].find(valueCellLocator).text
    }
    return tableInformation
  }
}