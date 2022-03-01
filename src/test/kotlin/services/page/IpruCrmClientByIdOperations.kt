package services.page

import core.ui.page.CrmClientByIdPage
import io.qameta.allure.Step

class IpruCrmClientByIdOperations {

  private val crmClientIdPage: CrmClientByIdPage by lazy { CrmClientByIdPage() }

  @Step
  fun getInformationByClientId(): Map<String, String> {
    crmClientIdPage.verifyClientIdPageOpened()
    return crmClientIdPage.getClientIdDetailsFromTable()
  }
}