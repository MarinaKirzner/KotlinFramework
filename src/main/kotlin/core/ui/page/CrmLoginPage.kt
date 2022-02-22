package core.ui.page

import core.context.constant.StaticContextHolder.getConfig
import core.ui.element.Browser.verifyCurrentUrl
import core.ui.element.Button.clickButton
import core.ui.element.Input.setInputValue
import org.openqa.selenium.By

class CrmLoginPage : BasePage() {

  override val url: String = getConfig().run { getCrmEndpointUrl(crmLoginUrl) }
  private val crmEmailField: By = By.id("login")
  private val crmPassField: By = By.id("password")
  private val crmRegistrationButton: By = By.xpath("//button[@type='submit']")

  fun inputEmail(email: String) {
    setInputValue(crmEmailField, email)
  }

  fun inputPassword(password: String) {
    setInputValue(crmPassField, password)
  }

  fun loginButton() {
    clickButton(crmRegistrationButton)
  }

  fun verifyLoginUrl() {
    verifyCurrentUrl(url)
  }
}