import core.api.crm.controller.CrmController
import core.api.mock.controller.WireMockController
import core.api.mock.model.CrmMockConfig
import core.context.constant.StaticContextHolder.getConfig
import core.http.response.HttpClientResponse
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LoginApiCrmWireMockTest : BaseTest() {

  private lateinit var baseWireMockUrl: String
  private val crmMockConfig: CrmMockConfig = CrmMockConfig()

  @BeforeEach
  fun configWireMockStub() {
    baseWireMockUrl = getConfig().getWireMockUrl()
    WireMockController().setUpMock(crmMockConfig)
  }

  @AfterEach
  fun removeWireMockStub() {
    WireMockController().deleteMock(crmMockConfig)
  }

  @Test
  fun `Raise Crm Authorisation Mock and verify the AuthUser cookie is set when logging into CRM with incorrect credentials`() {
    val response: HttpClientResponse = CrmController(baseWireMockUrl).authCrm()
    val expectedCookieHeaderName: String? = response.getCookie()
    val actualCookieHeaderName: String? = crmMockConfig.header[response.cookieHeaderName]
    Assertions.assertEquals(expectedCookieHeaderName, actualCookieHeaderName, "$expectedCookieHeaderName contains no data")
  }
}