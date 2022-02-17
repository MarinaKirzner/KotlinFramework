package services.page

import core.ui.page.CrmBasePage
import io.qameta.allure.Step

class IpruCrmBasePageOptions {

  private val crmBasePage: CrmBasePage by lazy { CrmBasePage() }
  private val ipruCrmClientPageOptions: IpruCrmClientPageOptions = IpruCrmClientPageOptions()

  @Step
  fun verifyCrmBasePage() {
    crmBasePage.verifyBasePageUrl()
  }

  @Step
  fun openCrmClientsPage() {
    ipruCrmClientPageOptions.apply {
      selectCrmClientsPage()
    }
  }
}