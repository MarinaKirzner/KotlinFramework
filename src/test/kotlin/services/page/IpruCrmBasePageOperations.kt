package services.page

import core.ui.page.CrmBasePage
import io.qameta.allure.Step

class IpruCrmBasePageOperations {

  private val crmBasePage: CrmBasePage by lazy { CrmBasePage() }
  private val ipruCrmClientPageOperations: IpruCrmClientPageOperations = IpruCrmClientPageOperations()

  @Step
  fun verifyCrmBasePage() {
    crmBasePage.verifyBasePageUrl()
  }

  @Step
  fun openCrmClientsPage() {
    ipruCrmClientPageOperations.apply {
      selectCrmClientsPage()
    }
  }
}