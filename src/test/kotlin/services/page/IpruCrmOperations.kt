package services.page

import core.ui.crm.ClientType
import core.ui.page.CrmClientByIdPage
import core.ui.page.CrmClientsPage
import core.ui.page.CrmLeadsPage
import io.qameta.allure.Step

class IpruCrmOperations {

  private val crmLeadsPage: CrmLeadsPage by lazy { CrmLeadsPage() }
  private val crmClientsPage: CrmClientsPage by lazy { CrmClientsPage() }
  private val crmClientIdPage: CrmClientByIdPage by lazy {
    CrmClientByIdPage(
      clientId = crmClientsPage.getClientIdFromSearchResults()
    )
  }

  @Step
  fun openCrmClientsPage() {
    crmLeadsPage.apply {
      verifyPageOpened()
      clickCrmClientsPage()
    }
    crmClientsPage.verifyPageOpened()
  }

  @Step
  fun searchClientsByType(clientType: ClientType) {
    crmClientsPage.crmClientsFilterBlock.apply {
      selectClientTypeByFilterBlock(clientType)
      clickSearchButtonByFilterBlock()
    }
    crmClientsPage.crmClientsSearchResultsBlock.verifyBlockDisplayed()
  }

  @Step
  fun openClientIdPageFromRowOfTable(clientId: String) {
    crmClientsPage.openSelectedClientIdPage(clientId)
    crmClientIdPage.verifyClientIdPageOpened()
  }

  @Step
  fun getInformationByClientId(): Map<String, String> {
    return crmClientIdPage.crmClientDetailsBlock.getClientIdMainDetailsFromTable()
  }
}