package core.page

import core.`object`.Button.clickButton
import core.`object`.InputValue.setInputValue
import core.holder.staticContext.StaticContextHolder
import org.openqa.selenium.By
import org.openqa.selenium.By.id
import org.openqa.selenium.By.xpath

class LandingPage : BasePage() {

  override val url: String = StaticContextHolder.getConfig().getBaseUrlWithAuth()
  private val acceptCookiesButton: By = By.xpath("//button[text()='Aceptar todo']")
  private val creditAmountInput: By = id("loanAmount")
  private val loanDaysInput: By = id("loanDays")
  private val requestRegistrationButton: By = xpath("//a[@class='btn btn_red mainCalculator__submit']")

  fun acceptCookies() {
    clickButton(acceptCookiesButton)
  }

  fun creditAmount(sum: String) {
    setInputValue(creditAmountInput, sum)
  }

  fun loanDays(loan: String) {
    setInputValue(loanDaysInput, loan)
  }

  fun requestRegistration() {
    clickButton(requestRegistrationButton)
  }
}