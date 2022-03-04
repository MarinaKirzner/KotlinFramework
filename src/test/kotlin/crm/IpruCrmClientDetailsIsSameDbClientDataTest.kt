package crm

import BaseTest
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import core.db.TafDbClient
import core.ui.crm.ClientType
import core.ui.crm.model.ClientDetailsConfig
import core.ui.driver.setter.DriverConfigSetter
import core.ui.page.CrmClientsPage
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import services.db.IpruDatabaseOperations
import services.page.IpruCrmLoginPageOperations
import services.page.IpruCrmOperations

class IpruCrmClientDetailsIsSameDbClientDataTest : BaseTest() {

  @BeforeEach
  fun loginCrmPage() {
    DriverConfigSetter().setDriverConfig()
    IpruCrmLoginPageOperations().loginCrm()
  }

  @AfterEach
  fun sessionClose() {
    TafDbClient().closeDbConnection()
  }

  @Test
  fun `CRM - UI - Client main-data in the UI is the same as the client data in the database`() {
    val crmClientIdDetails: Map<String, String>
    val clientId: String = CrmClientsPage().getClientIdFromSearchResults()
    IpruCrmOperations().apply {
      openCrmClientsPage()
      searchClientsByType(ClientType.INDIVIDUAL)
      openClientIdPageFromRowOfTable(clientId)
      crmClientIdDetails = getInformationByClientId()
    }
    val dbClientIdDetails: Map<String, Any> = IpruDatabaseOperations().dbSelectClientData(clientId)
    val actualDbClientDetails = jacksonObjectMapper().convertValue(dbClientIdDetails, ClientDetailsConfig::class.java)
    val expectedCrmClientDetails = jacksonObjectMapper().convertValue(crmClientIdDetails, ClientDetailsConfig::class.java)
    Assertions.assertEquals(
      expectedCrmClientDetails, actualDbClientDetails, "Client data on UI and Database is different"
    )
  }
}