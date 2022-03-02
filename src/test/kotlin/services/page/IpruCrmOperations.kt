package services.page

import com.codeborne.selenide.Selenide.`$`
import core.ui.block.CrmClientMainDetailsBlock
import core.ui.crm.ClientType
import core.ui.page.CrmClientByIdPage
import core.ui.page.CrmClientPage
import core.ui.page.CrmLeadsPage
import io.qameta.allure.Step
import org.openqa.selenium.By

class IpruCrmOperations {

  private val crmLeadsPage: CrmLeadsPage by lazy { CrmLeadsPage() }
  private val clientPage: CrmClientPage by lazy { CrmClientPage() }
  private val crmClientIdPage: CrmClientByIdPage by lazy { CrmClientByIdPage(clientId = clientPage.clientId) }

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