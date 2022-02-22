package services.page

import core.ui.page.CrmClientPage
import io.qameta.allure.Step

class IpruCrmClientPageOperations {

  private val clientPage: CrmClientPage by lazy { CrmClientPage() }

  @Step
  fun verifyClientsPage() {
    clientPage.verifyCrmClientsPage()
  }

  @Step
  fun selectCrmClientsTypePage(clientType: String) {
    clientPage.selectClientTypeByFilter(clientType)
  }

  @Step
  fun selectCrmClientIdPage(clientId: String) {
    clientPage.selectClientIdFromTable(clientId)
  }
}