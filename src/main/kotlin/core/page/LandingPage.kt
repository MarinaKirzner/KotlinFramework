package core.page

import com.codeborne.selenide.Condition
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.open
import core.`object`.Button.clickButton
import core.`object`.InputValue.setInputValue
import core.holder.StaticContextHolder.applicationConfig
import org.openqa.selenium.By
import org.openqa.selenium.By.id
import org.openqa.selenium.By.xpath

open class LandingPage : BasePage() {

  override val url: String = "https://${applicationConfig?.user}:${applicationConfig?.pass}@${applicationConfig?.host}"

  val acceptCookiesButton: By = By.xpath("//button[text()='Aceptar todo']")
  val creditAmountInput: By = id("loanAmount")
  val loanDaysInput: By = id("loanDays")
  val requestRegistrationButton: By = xpath("//a[@class='btn btn_red mainCalculator__submit']")

  override fun openPage() {
    open(url)
  }

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