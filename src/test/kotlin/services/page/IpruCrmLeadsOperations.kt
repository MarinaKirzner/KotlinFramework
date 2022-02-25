package services.page

import core.ui.page.CrmLeadsPage
import io.qameta.allure.Step

class IpruCrmLeadsOperations {

  private val crmLeadsPage: CrmLeadsPage by lazy { CrmLeadsPage() }

  @Step
  fun openCrmClientsPage() {
    crmLeadsPage.apply {
      verifyPageOpened()
      clickCrmClientsPage()
    }
  }
}