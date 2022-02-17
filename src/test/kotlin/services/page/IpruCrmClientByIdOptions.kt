package services.page

import core.ui.page.CrmClientByIdPage
import io.qameta.allure.Step

class IpruCrmClientByIdOptions {

  private val crmClientByIdPage: CrmClientByIdPage by lazy { CrmClientByIdPage() }

  @Step
  fun selectInformationFromCrmClientByIdPage() {
    crmClientByIdPage.selectClientInformation()
  }
}