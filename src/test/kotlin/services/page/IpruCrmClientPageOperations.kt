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
  fun sortingClientsByType(clientType: String) {
    clientPage.apply {
      selectClientTypeByFilter(clientType)
      clickSearchButtonByFilter()
      crmClientsTableBlock.verifyClientDetailsBlockDisplayed()
    }
  }

  @Step
  fun openClientIdFromFirstRowOfTable() {
    clientPage.openClientIdPage()
  }
}