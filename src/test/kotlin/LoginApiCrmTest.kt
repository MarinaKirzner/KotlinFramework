import core.api.crm.controller.CrmController
import core.holder.StaticContextHolder
import core.provider.ApplicationConfigProvider
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LoginApiCrmTest : BaseTest() {

  private val authUserCookieName: String = "AuthUser"

  @Test
  fun `Login to CRM using Retrofit`() {
    val expectedAuthUserValue = CrmController().authCrm().getValueFromCookies(authUserCookieName)
    Assertions.assertNotNull(expectedAuthUserValue, "$authUserCookieName contains no data")
  }
}
