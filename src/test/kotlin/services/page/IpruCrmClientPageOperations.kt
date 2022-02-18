package services.page

import core.ui.page.CrmClientPage
import io.qameta.allure.Step

class IpruCrmClientPageOperations {

  private val clientPage: CrmClientPage by lazy { CrmClientPage() }

  @Step
  fun selectCrmClientsPage() {
    clientPage.apply {
      getCrmClientsPage()
      verifyClientsPageUrl()
    }
  }

  @Step
  fun selectClientTypeByCrmClientsPage(clientType: String) {
    clientPage.apply {
      verifyClientsFilterByPage()
      selectClientTypeByDropdown(clientType)
      verifyClientsTableFromPage()
    }
  }

  @Step
  fun selectClientByIdFromCrmClientsPage(clientId: String) {
    clientPage.apply {
      selectClientById(clientId)
      verifyClientByIdPageUrl(clientId)
    }
  }
}