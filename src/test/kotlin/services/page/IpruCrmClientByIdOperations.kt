package services.page

import core.ui.page.CrmClientByIdPage
import io.qameta.allure.Step

class IpruCrmClientByIdOperations {

  private val crmClientByIdPage: CrmClientByIdPage by lazy { CrmClientByIdPage() }

  @Step
  fun selectInformationFromCrmClientByIdPage(clientId: String) {
    crmClientByIdPage.apply {
      verifyClientByIdPageUrl(clientId)
      verifyClientIdInformationBlock()
      selectClientMainInformation()
    }
  }
}