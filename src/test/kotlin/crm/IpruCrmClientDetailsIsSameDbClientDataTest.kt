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

  private val expectedClientType: ClientType = ClientType.INDIVIDUAL
  private lateinit var tafDbClient: TafDbClient
  private lateinit var actualCrmClientIdDetails: ClientDetailsConfig
  private lateinit var expectedDbClientIdDetails: ClientDetailsConfig

  @BeforeEach
  fun loginCrmPage() {
    DriverConfigSetter().setDriverConfig()
    tafDbClient = TafDbClient()
    IpruCrmLoginPageOperations().loginCrm()
  }

  @AfterEach
  fun sessionClose() {
    tafDbClient.closeDbConnection()
  }

  @Test
  fun `CRM - UI - Client main-data in the UI is the same as the client data in the database`() {
    val clientId: String = CrmClientsPage().getClientIdFromSearchResults()
    IpruCrmOperations().apply {
      openCrmClientsPage()
      searchClientsByType(expectedClientType)
      openClientIdPageFromRowOfTable(clientId)
      actualCrmClientIdDetails = getInformationByClientId()
    }
    val dbClientIdDetails: Map<String, Any> = IpruDatabaseOperations(tafDbClient).dbSelectClientData(clientId)
    expectedDbClientIdDetails = jacksonObjectMapper().convertValue(dbClientIdDetails, ClientDetailsConfig::class.java)
    Assertions.assertEquals(
      actualCrmClientIdDetails, expectedDbClientIdDetails, "Client data on UI and Database is different"
    )
  }
}