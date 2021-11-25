package uiAutomation.button

import org.openqa.selenium.By
import uiAutomation.enum.LocatorType
import java.io.FileInputStream
import java.util.*

class Locator {
  companion object {
    val locators = Properties()
    val inputFile = FileInputStream("src/test/resources/locators.properties")

    init {
      locators.load(inputFile)
    }

    fun getLocator(locatorName: String): By {
      val propertyValue = locators.getProperty(locatorName)
      val locatorItem = propertyValue.split("=", limit = 2).toTypedArray()
      val locatorType = LocatorType.valueOf(locatorItem[0])

      return when (locatorType) {
        LocatorType.xpath -> By.xpath(locatorItem[1])
        LocatorType.id -> By.id(locatorItem[1])
      }
    }
  }
}