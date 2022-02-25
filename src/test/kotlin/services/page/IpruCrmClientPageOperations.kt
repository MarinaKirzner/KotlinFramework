package services.page

import core.ui.page.CrmClientPage
import io.qameta.allure.Step

class IpruCrmClientPageOperations {

  private val clientPage: CrmClientPage by lazy { CrmClientPage() }

  @Step
  fun verifyClientsPageOpen() {
    clientPage.verifyPageOpened()
  }

  @Step
  fun selectCrmClientsType(clientType: String) {
    clientPage.apply {
      selectClientTypeByFilter(clientType)
      crmClientFilter.clickSearchButtonByFilterBlock()
    }
  }

  @Step
  fun openCrmClientIdPage(clientId: String) {
    clientPage.openClientIdPage(clientId)
  }
}