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
  private lateinit var crmClientIdPage: CrmClientByIdPage

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
    crmClientIdPage = CrmClientByIdPage( clientId = crmClientsPage.getClientIdFromSearchResults() )
    crmClientIdPage.verifyClientIdPageOpened()
  }

  @Step
  fun getInformationByClientId(): ClientDetailsConfig {
    val clientIdDetails: Map<String, Any> = crmClientIdPage.crmClientMainDetailsBlock.getClientMainDetailsFromTable()
    return ClientDetailsConfig(
      nickname = clientIdDetails["Имя из обращения"].toString(),
      resident = ClientDetailsConfig.convertToResidentBooleanValue(clientIdDetails["Резидент"].toString()),
      identificationNumber = clientIdDetails["ИНН"].toString(),
      surname = clientIdDetails["Фамилия"].toString(),
      name = clientIdDetails["Имя"].toString(),
      middleName = clientIdDetails["Отчество"].toString(),
      fullNameChanged = ClientDetailsConfig.convertToFullNameChangedValue(
        clientIdDetails["Менялись ли ФИО?"].toString()),
      previousSurname = clientIdDetails["Предыдущая фамилия (если менялась)"] as String?,
      previousName = clientIdDetails["Предыдущее имя (если менялось)"] as String?,
      previousMiddleName = clientIdDetails["Предыдущее отчество (если менялось)"] as String?,
      insuranceNumber = ClientDetailsConfig.convertInsuranceNumber(clientIdDetails["СНИЛС"].toString())
    )
  }
}