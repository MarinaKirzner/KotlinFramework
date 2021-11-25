package uiAutomation.base

import com.codeborne.selenide.Selenide.open
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import uiAutomation.button.ButtonElement.acceptCookies
import uiAutomation.button.Locator.Companion.getLocator
import uiAutomation.factory.ReadYamlFile
import uiAutomation.provider.WebDriverFactory.Companion.driver
import uiAutomation.provider.WebDriverFactory.Companion.quit
import uiAutomation.provider.WebDriverFactory.Companion.setDriver

open class TestBase {
  companion object {
    val user = "moneyman"
    val pass = "1005"
  }

  @BeforeEach
  fun setup() {
    setDriver(ReadYamlFile().readConfigFile())
    open("https://" + user + ":" + pass + "@qa-delivery-es-release.moneyman.ru")
    acceptCookies(getLocator("ButtonElement.acceptCookies"))
  }

  @AfterEach
  fun quitDriver() {
    quit()
  }
}