package crm

import BaseTest
import core.db.SqlQuery.selectMainDataFromClientByDb
import core.db.SqlQuery.selectOtherDataFromClientByDb
import core.db.TafDbClient
import core.ui.driver.setter.DriverConfigSetter
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import services.db.IpruDatabaseOperations
import services.page.IpruCrmClientByIdOperations
import services.page.IpruCrmClientPageOperations
import services.page.IpruCrmLeadsOperations
import services.page.IpruCrmLoginPageOperations

class ValidationCrmClientDetaiIsSameDbClientDataTest : BaseTest() {

  private lateinit var tafDbClient: TafDbClient
  private val ipruCrmClientPageOperations: IpruCrmClientPageOperations = IpruCrmClientPageOperations()
  private val clientType: String = "Физическое лицо"
  private val clientId: String = "959"

  @BeforeEach
  fun loginCrmPage() {
    tafDbClient = TafDbClient()
    DriverConfigSetter().setDriverConfig()
    IpruCrmLoginPageOperations().loginCrm()
  }

  @AfterEach
  fun sessionClose() {
    tafDbClient.closeDbConnection()
  }

  @Test
  fun `CRM - UI - Validation client main-data in the UI is the same as the client data in the database`() {
    IpruCrmLeadsOperations().openCrmClientsPage()
    ipruCrmClientPageOperations.apply {
      verifyClientsPageOpen()
      selectCrmClientsType(clientType)
      openCrmClientIdPage(clientId)
    }
    IpruCrmClientByIdOperations().getInformationByClientId(clientId)

    val idClient: Map<String, String> = mapOf("id" to clientId)
    IpruDatabaseOperations().dbSelectClientData(selectMainDataFromClientByDb, selectOtherDataFromClientByDb, idClient)
  }
}