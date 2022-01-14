import core.api.crm.controller.CrmController
import core.api.mock.controller.WireMockController
import core.api.mock.model.CrmMockConfig
import core.context.constant.StaticContextHolder
import core.http.response.HttpClientResponse
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LoginApiCrmWireMockTest : BaseTest() {

  private val authUserValue: String = "AuthUser"
  private val actualAuthUserValue = "eyJhbGciOiJIUzUxMiJ9"
  private lateinit var baseWireMockUrl: String

  @BeforeEach
  fun configWireMockStub() {
    WireMockController().setUpMock()
    baseWireMockUrl = StaticContextHolder.getConfig().getWireMockUrl()
    println(CrmMockConfig().header.values.toString())
  }

  @AfterEach
  fun removeWireMockStub() {
    WireMockController().deleteMock()
  }

  @Test
  fun `Start WireMock and verify the AuthUser cookie is set when logging into CRM with incorrect credentials`() {
    val response: HttpClientResponse = CrmController(baseWireMockUrl).authCrm()
    val expectedAuthUserValue: String? = response.getValueFromCookies(authUserValue)
    Assertions.assertEquals(expectedAuthUserValue, actualAuthUserValue, "$expectedAuthUserValue contains no data")
  }
}