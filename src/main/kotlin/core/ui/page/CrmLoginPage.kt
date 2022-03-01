package core.ui.page

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import core.context.constant.StaticContextHolder.getConfig
import core.ui.element.Button.clickButton
import core.ui.element.Input.setInputValue
import org.openqa.selenium.By

class CrmLoginPage : BasePage() {

  override val url: String = getConfig().getCrmUrlWithSelectedEndpoint("/crm#/login")
  private val crmEmailFieldLocator: By = By.id("login")
  private val crmPassFieldLocator: By = By.id("password")
  private val crmLoginButtonLocator: By = By.cssSelector("button[type='submit']")

  fun verifyPageOpened() {
    super.verifyPageOpen()
    `$`(crmLoginButtonLocator).shouldBe(Condition.visible)
  }

  fun inputEmail(email: String) {
    setInputValue(crmEmailFieldLocator, email)
  }

  fun inputPassword(password: String) {
    setInputValue(crmPassFieldLocator, password)
  }

  fun clickLoginButton() {
    clickButton(crmLoginButtonLocator)
  }
}