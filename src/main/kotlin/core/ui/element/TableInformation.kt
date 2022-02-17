package core.ui.element

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.`$$`
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.openqa.selenium.By

object TableInformation {

  private val logger: Logger = LogManager.getLogger()

  fun getClientInformation(cellType: By, cellTypeDetails: By) {
    logger.info("Get client information from table")
    val contactDetails: ElementsCollection = `$$`(cellType)
    val valueByContactDetails: ElementsCollection = `$$`(cellTypeDetails)
    val crmClientInformation: MutableMap<String, String> = mutableMapOf()
    crmClientInformation.apply {
      for (i in 0 until contactDetails.size) {
        crmClientInformation[contactDetails[i].text] = valueByContactDetails[i].text
      }
    }
  }
}