import core.http.httpClient.IntegrationHttpClient
import core.model.ApplicationConfig
import core.provider.ApplicationConfigProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CallRegistrationUrlTest {

  val applicationConfig: ApplicationConfig = ApplicationConfigProvider().getApplicationConfig()
  val registrationUrl: String = ApplicationConfigProvider().getEndPointUrlWithAuthentication()
  val authUser: String = "AuthUser"

  @Test
  fun `Send a GET request to registration endpoint and verify AuthUser not empty`() {
    val authUserValue: String? = IntegrationHttpClient().makeGetRequest(registrationUrl).getValueFromCookies(authUser)
    Assertions.assertNotNull(authUserValue, "$authUser contains no data")
  }
}