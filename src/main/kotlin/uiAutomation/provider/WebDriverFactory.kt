package uiAutomation.provider

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver

class WebDriverFactory {

  companion object {
    lateinit var driverFactory: String
    var driver: WebDriver? = null

    fun setDriver(driverFactory: String) {
      Companion.driverFactory = driverFactory
    }

    fun getWebDriver(): WebDriver {
      if (driver == null) {
        when (driverFactory) {
          "CHROME" -> driver = ChromeDriver()
          "FIREFOX" -> driver = FirefoxDriver()
        }
      }
      return driver as WebDriver
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