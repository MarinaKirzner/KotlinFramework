package core.ui.element

import com.codeborne.selenide.ElementsCollection
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object TableInformation {

  private val logger: Logger = LogManager.getLogger()

  fun clientInformationFromTable(cellType: ElementsCollection, cellTypeDetails: ElementsCollection): MutableMap<String, String> {
    logger.info("Get client information from table")
    val crmClientInformation: MutableMap<String, String> = mutableMapOf()
    crmClientInformation.apply {
      for (i in 0 until cellType.size) {
        crmClientInformation[cellType[i].text] = cellTypeDetails[i].text
      }
    }
    return crmClientInformation
  }
}