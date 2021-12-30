package exercise.selenium.projectArchitecture.core

import exercise.selenium.projectArchitecture.core.enum.LocatorType
import org.openqa.selenium.By
import java.io.FileInputStream
import java.util.*

class Locator {

  companion object {
    val locators = Properties()
    val inputFile = FileInputStream("src/main/resources/locators.properties")

    init {
      locators.load(inputFile)
    }

    fun getLocator(locatorName: String): By {
      val propertyValue = locators.getProperty(locatorName)
      val locatorItem = propertyValue.split("=", limit = 2).toTypedArray()
      val locatorType = LocatorType.valueOf(locatorItem[0])

      return when (locatorType) {
        LocatorType.cssSelector -> By.cssSelector(locatorItem[1])
        LocatorType.xpath -> By.xpath(locatorItem[1])
      }
    }
  }
}