package services.page

import core.ui.crm.ClientType
import core.ui.crm.model.ClientDetailsConfig
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
  fun getInformationByClientId(): ClientDetailsConfig {
    val clientIdDetails: Map<String, Any> = crmClientIdPage.getCrmClientIdDetails()
    return ClientDetailsConfig(
      nickname = clientIdDetails["Имя из обращения"] as String?,
      resident = ClientDetailsConfig.convertToResidentBooleanValue(clientIdDetails["Резидент"] as String),
      identificationNumber = clientIdDetails["ИНН"] as String?,
      surname = clientIdDetails["Фамилия"] as String?,
      name = clientIdDetails["Имя"] as String?,
      middleName = clientIdDetails["Отчество"] as String?,
      fullNameChanged = ClientDetailsConfig.convertToFullNameChangedValue(clientIdDetails["Менялись ли ФИО?"] as String),
      previousSurname = clientIdDetails["Предыдущая фамилия (если менялась)"] as String?,
      previousName = clientIdDetails["Предыдущее имя (если менялось)"] as String?,
      previousMiddleName = clientIdDetails["Предыдущее отчество (если менялось)"] as String?,
      insuranceNumber = ClientDetailsConfig.convertInsuranceNumber(clientIdDetails["СНИЛС"] as String)
    )
  }
}