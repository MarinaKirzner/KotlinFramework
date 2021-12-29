import core.context.httpClientResponse
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LoginApiCrmTest : BaseTest() {

  private val authUserCookieName: String = "AuthUser"

  @Test
  fun `Login to CRM using Retrofit`() {
    val expectedAuthUserValue = httpClientResponse().getValueFromCookies(authUserCookieName)
    Assertions.assertNotNull(expectedAuthUserValue, "$authUserCookieName contains no data")
  }
}