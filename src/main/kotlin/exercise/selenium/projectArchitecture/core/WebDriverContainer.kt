package exercise.selenium.projectArchitecture.core

import exercise.selenium.projectArchitecture.core.enum.DriverType
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import java.util.concurrent.TimeUnit

class WebDriverContainer {

  companion object {
    lateinit var driverType: DriverType
    var driver: WebDriver? = null

    fun setDriver(driverType: DriverType) {
      WebDriverContainer.driverType = driverType
    }

    fun getWebDriver(): WebDriver {
      if (driver == null) {
        when (driverType) {
          DriverType.CHROME -> driver = ChromeDriver()
          DriverType.FIREFOX -> driver = FirefoxDriver()
        }
      }
      driver?.manage()?.window()?.maximize()
      driver?.manage()?.timeouts()?.implicitlyWait(10, TimeUnit.SECONDS)
      return driver as WebDriver
    }

    fun getElement(locator: By): WebElement? {
      return getWebDriver().findElement(locator)
    }

    fun getElements(locator: By): List<WebElement>? {
      return getWebDriver().findElements(locator)
    }

    fun open(url: String) {
      getWebDriver().get(url)
    }

    fun quit() {
      if (driver != null) {
        driver?.quit()
        driver = null
      }
    }
  }
}