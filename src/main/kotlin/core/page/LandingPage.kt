package core.page

import com.codeborne.selenide.Selenide.open
import core.`object`.ClickButton.clickButton
import core.`object`.InputValue.setInputValue
import core.model.DataConfig
import core.provider.ReadDataConfigProvider
import org.openqa.selenium.By
import org.openqa.selenium.By.id
import org.openqa.selenium.By.xpath

class LandingPage : BasePage() {

  private val dataConfig: DataConfig = ReadDataConfigProvider().getDataConfig()
  override val url: String = "https://${dataConfig.user}:${dataConfig.pass}@${dataConfig.host}"

  val acceptCookies: By = By.xpath("//button[text()='Aceptar todo']")
  val creditAmount: By = id("loanAmount")
  val loanDays: By = id("loanDays")
  val requestRegistration: By = xpath("//a[@class='btn btn_red mainCalculator__submit']")

  override fun openPage() {
    open(url)
  }

  fun acceptCookies() {
    clickButton(acceptCookies)
  }

  fun creditAmount(sum: String) {
    setInputValue(creditAmount, sum)
  }

  fun loanDays(loan: String) {
    setInputValue(loanDays, loan)
  }

  fun requestRegistration() {
    clickButton(requestRegistration)
  }
}