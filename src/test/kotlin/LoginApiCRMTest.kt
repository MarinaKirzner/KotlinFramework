import core.api.crm.controller.CrmController
import core.holder.StaticContextHolder
import core.provider.ApplicationConfigProvider
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LoginApiCRMTest : BaseTest() {

  private val authUser: String = "AuthUser"

  @Test
  fun `Login to CRM using Retrofit`() {
    val authUserValue = CrmController().authCrm().getValueFromCookies(authUser)
    Assertions.assertNotNull(authUserValue, "$authUser contains no data")
  }
}
