package core.ui.page

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import core.context.constant.StaticContextHolder.getConfig
import core.ui.element.Button.clickButton
import core.ui.element.Input.setInputValue
import org.openqa.selenium.By

class CrmLoginPage : BasePage() {

  override val url: String = getConfig().getCrmUrlWithSelectedEndpoint("/crm#/login")
  private val crmEmailField: By = By.id("login")
  private val crmPassField: By = By.id("password")
  private val crmRegistrationButton: By = By.cssSelector("button[type='submit']")

  fun verifyPageOpened(){
    super.isPageOpen()
    `$`(crmRegistrationButton).shouldBe(Condition.visible)
  }

  fun inputEmail(email: String) {
    setInputValue(crmEmailField, email)
  }

  fun inputPassword(password: String) {
    setInputValue(crmPassField, password)
  }

  fun clickLoginButton() {
    clickButton(crmRegistrationButton)
  }
}