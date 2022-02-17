package services.page

import core.context.ipruCrmConfig
import core.ui.page.CrmLoginPage
import io.qameta.allure.Step

class IpruCrmLoginPageOptions {

  private val crmLoginPage: CrmLoginPage by lazy { CrmLoginPage() }

  @Step
  fun loginCrm() {
    openLoginPage()
    setEmailAndPass(ipruCrmConfig.email, ipruCrmConfig.pass)
    clickLogin()
  }

  @Step
  fun openLoginPage() {
    crmLoginPage.apply {
      openPage()
      verifyLoginUrl()
    }
  }

  @Step
  fun setEmailAndPass(email: String, pass: String) {
    crmLoginPage.apply {
      inputEmail(email)
      inputPassword(pass)
    }
  }

  @Step
  fun clickLogin() {
    crmLoginPage.loginButton()
  }
}