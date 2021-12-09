import core.http.httpClient.IntegrationHttpClient
import core.model.ApplicationConfig
import core.provider.ApplicationConfigProvider
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class OkHttpClientTest {

  val applicationConfig: ApplicationConfig = ApplicationConfigProvider().getApplicationConfig()
  val url: String = applicationConfig.getHostWithBasicAuth()
  val authUser: String = "AuthUser"

  @Test
  fun `Send a GET request to registration endpoint and verify AuthUser not empty`() {
    val authUserValue: String? = IntegrationHttpClient().makeGetRequest(url).getValueFromCookies(authUser)
    Assertions.assertNotNull(authUserValue, "$authUser contains no data")
  }
}