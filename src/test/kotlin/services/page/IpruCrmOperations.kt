package services.page

import core.ui.crm.ClientType
import core.ui.page.CrmClientByIdPage
import core.ui.page.CrmClientPage
import core.ui.page.CrmLeadsPage
import io.qameta.allure.Step

class IpruCrmOperations {

  private val crmLeadsPage: CrmLeadsPage by lazy { CrmLeadsPage() }
  private val clientPage: CrmClientPage by lazy { CrmClientPage() }
  private val crmClientIdPage: CrmClientByIdPage by lazy { CrmClientByIdPage(clientId = "403") }

  @Step
  fun openCrmClientsPage() {
    crmLeadsPage.apply {
      verifyPageOpened()
      clickCrmClientsPage()
    }
    clientPage.verifyPageOpened()
  }

  @Step
  fun sortingClientsByType(clientType: ClientType) {
    clientPage.crmClientFilterBlock.apply {
      selectClientTypeByFilterBlock(clientType)
      clickSearchButtonByFilterBlock()
    }
    clientPage.crmClientsTableBlock.verifyBlockDisplayed()
  }

  @Step
  fun openClientIdPageFromFirstRowOfTable() {
    clientPage.openClientIdPage()
    crmClientIdPage.verifyClientIdPageOpened()
  }

  @Step
  fun getInformationByClientId(): Map<String, String> {
    return crmClientIdPage.crmClientDetailsBlock.getClientIdMainDetailsFromTable()
  }
}