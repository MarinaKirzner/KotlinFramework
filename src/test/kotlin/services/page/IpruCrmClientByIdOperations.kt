package services.page

import core.ui.page.CrmClientByIdPage
import io.qameta.allure.Step

class IpruCrmClientByIdOperations {

  private val crmClientIdPage: CrmClientByIdPage by lazy { CrmClientByIdPage() }

  @Step
  fun getInformationByClientId(id: String): Map<String, String> {
    crmClientIdPage.verifyClientIdPageOpened(id)
    return crmClientIdPage.getClientIdDetailsFromTable()
  }
}