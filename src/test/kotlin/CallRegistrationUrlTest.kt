import core.http.httpClient.IntegrationHttpClient
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import step.RegistrationPageSteps

class CallRegistrationUrlTest : BaseTest() {

  val authUser: String = "AuthUser"

  @Test
  fun `Send a GET request to registration endpoint and verify AuthUser not empty`() {
    val authUserValue: String? = IntegrationHttpClient()
      .makeGetRequest(RegistrationPageSteps().registrationUrl)
      .getValueFromCookies(authUser)
    Assertions.assertNotNull(authUserValue, "$authUser contains no data")
  }
}