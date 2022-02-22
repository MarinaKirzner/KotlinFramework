import core.ui.driver.setter.DriverConfigSetter
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import services.page.IpruCrmBasePageOperations
import services.page.IpruCrmClientByIdOperations
import services.page.IpruCrmClientPageOperations
import services.page.IpruCrmLoginPageOperations

class ValidationCrmClientDataIsSameDbClientDataTest : BaseTest() {

  private val ipruCrmClientPageOperations: IpruCrmClientPageOperations = IpruCrmClientPageOperations()
  private val clientType: String = "Физическое лицо"
  private val clientId: String = "604"

  @BeforeEach
  fun loginCrmPage() {
    DriverConfigSetter().setDriverConfig()
    IpruCrmLoginPageOperations().loginCrm()
  }

  @Test
  fun `CRM - UI - Validation client main-data in the UI is the same as the client data in the database`() {
    IpruCrmBasePageOperations().apply {
      verifyCrmBasePage()
      openCrmClientsPage()
    }
    ipruCrmClientPageOperations.apply {
      verifyClientsPage()
      selectCrmClientsTypePage(clientType)
      selectCrmClientIdPage(clientId)
    }
    IpruCrmClientByIdOperations().selectInformationFromCrmClientByIdPage(clientId)
  }
}