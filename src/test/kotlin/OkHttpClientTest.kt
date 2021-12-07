import core.http.IntegrationHttpClient
import core.provider.ApplicationConfigProvider
import okhttp3.Call
import okhttp3.OkHttpClient
import okhttp3.Request
import org.junit.jupiter.api.Test

class OkHttpClientTest {

  val applicationConfig = ApplicationConfigProvider().getApplicationConfig()
  val registrationUrl = "qa-delivery-es-release.moneyman.ru/client-area/registration"
  val url = "https://${applicationConfig.user}:${applicationConfig.pass}@${registrationUrl}"

  @Test
  fun `Send a GET request and get AuthUser not empty`() {
    IntegrationHttpClient().makeGetRequest(url)
    println(IntegrationHttpClient().makeGetRequest(url))
  }
}