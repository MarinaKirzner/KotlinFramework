package services.page

import core.context.ipruConfig
import core.ui.crm.model.IpruCrmConfig
import core.ui.page.CrmLoginPage
import io.qameta.allure.Step

class IpruCrmLoginPageOperations {

  private val crmLoginPage: CrmLoginPage by lazy { CrmLoginPage() }

  @Step
  fun loginCrm(ipruCrmConfig: IpruCrmConfig? = ipruConfig) {
    ipruCrmConfig?.let {
      crmLoginPage.apply {
        openPage()
        verifyLoginUrl()
        inputEmail(ipruConfig.email)
        inputPassword(ipruConfig.pass)
        loginButton()
      }
    }
  }
}