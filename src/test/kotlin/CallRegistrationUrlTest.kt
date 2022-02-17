import core.http.client.IntegrationHttpClient
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import services.page.RegistrationPageSteps

class CallRegistrationUrlTest : BaseTest() {

  private val authUser: String = "AuthUser"

  @Test
  fun `Send a GET request to registration endpoint and verify AuthUser not empty`() {
    val expectedAuthUserValue: String? = IntegrationHttpClient()
      .makeGetRequest(RegistrationPageSteps().registrationUrl)
      .getValueFromCookies(authUser)
    Assertions.assertNotNull(expectedAuthUserValue, "$authUser contains no data")
  }
}