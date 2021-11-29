package core.page

import com.codeborne.selenide.Selenide.sleep
import com.codeborne.selenide.Selenide.webdriver
import com.codeborne.selenide.WebDriverConditions.url
import core.provider.ReadDataConfigProvider
import core.model.DataConfig

class RegistrationPage {

  private val dataConfig: DataConfig = ReadDataConfigProvider().getDataConfig()
  val urlRegistration: String = "https://${dataConfig.user}:${dataConfig.pass}@${dataConfig.host}${"/client-area/#/registration?"}"

  fun verifyPageUrl() {
    webdriver().shouldHave(url(urlRegistration))
    sleep(3000)
  }


}
