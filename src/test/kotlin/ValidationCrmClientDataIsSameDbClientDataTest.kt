import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import services.extention.IpruCrmExtension
import services.page.IpruCrmClientByIdOperations
import services.page.IpruCrmClientPageOperations

@ExtendWith(IpruCrmExtension::class)
class ValidationCrmClientDataIsSameDbClientDataTest: BaseTest() {

  private val ipruCrmClientPageOperations: IpruCrmClientPageOperations = IpruCrmClientPageOperations()
  private val clientType: String = "Физическое лицо"
  private val clientId: String = "456"

  @Test
  fun `CRM - UI - Validation client main-data in the UI is the same as the client data in the database`() {
    ipruCrmClientPageOperations.apply {
      selectClientTypeByCrmClientsPage(clientType)
      selectClientByIdFromCrmClientsPage(clientId)
    }
    IpruCrmClientByIdOperations().selectInformationFromCrmClientByIdPage()
  }
}