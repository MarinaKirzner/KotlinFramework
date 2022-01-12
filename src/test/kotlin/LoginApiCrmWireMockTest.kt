import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.aResponse
import com.github.tomakehurst.wiremock.client.WireMock.post
import core.api.crm.controller.CrmController
import core.http.response.HttpClientResponse
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class LoginApiCrmWireMockTest: BaseTest() {

  @Test
  fun `Start WireMock and verify the AuthUser cookie is set when logging into CRM with incorrect credentials`(){
    val wireMockClient = WireMock("localhost", 8080)
    wireMockClient.register(getMappingStub())
    val response: HttpClientResponse = CrmController().authCrm()
    val expectedAuthUserValue: String? = response.getValueFromCookies("AuthUser")
    Assertions.assertNotNull(expectedAuthUserValue, "$expectedAuthUserValue contains no data")
    println(expectedAuthUserValue)
  }

  private fun getMappingStub(): MappingBuilder =
    post(WireMock.urlMatching("/secure/rest/sign/in/"))
      .atPriority(1)
      .withName("MarinaStub")
      .willReturn(
        aResponse()
          .withStatus(200)
          .withHeader("Set-Cookie", "AuthUser=eyJhbGciOiJIUzUxMiJ9")
          .withBody(convertJsonAsString())
      )

  private fun convertJsonAsString(): String? =
    Thread.currentThread().contextClassLoader.getResourceAsStream("successCrmLoginResponse.json")
      ?.readBytes()?.toString(Charsets.UTF_8)
}