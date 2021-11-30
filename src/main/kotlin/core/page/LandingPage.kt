package core.page

import com.codeborne.selenide.Selenide.open
import core.`object`.ClickButton.clickButton
import core.`object`.InputValue.setInputValue
import core.model.ApplicationConfig
import core.provider.ApplicationConfigProvider
import org.openqa.selenium.By
import org.openqa.selenium.By.id
import org.openqa.selenium.By.xpath

class LandingPage : BasePage() {

  private val applicationConfig: ApplicationConfig = ApplicationConfigProvider().getDataConfig()
  override val url: String = "https://${applicationConfig.user}:${applicationConfig.pass}@${applicationConfig.host}"

  val acceptCookiesButton: By = By.xpath("//button[text()='Aceptar todo']")
  val creditAmountInput: By = id("loanAmount")
  val loanDaysInput: By = id("loanDays")
  val requestRegistrationButton: By = xpath("//a[@class='btn btn_red mainCalculator__submit']")

  override fun openPage() {
    open(url)
  }

  fun clickAcceptCookies() {
    clickButton(acceptCookiesButton)
  }

  fun setCreditAmount(sum: String) {
    setInputValue(creditAmountInput, sum)
  }

  fun setLoanDays(loan: String) {
    setInputValue(loanDaysInput, loan)
  }

  fun requestRegistration() {
    clickButton(requestRegistrationButton)
  }
}