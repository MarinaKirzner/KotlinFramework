package core.api.mock.model

import com.github.tomakehurst.wiremock.client.MappingBuilder
import core.reader.JsonFileRead

data class CrmMockConfig(
  override val priority: Int = 1,
  override val mockName: String = "LoginToCrmStub",
  override val statusCode: Int = 200,
  override val header: Map<String, String> = mapOf("Set-Cookie" to "AuthUser=eyJhbGciOiJIUzUxMiJ9"),
  override val body: String? = JsonFileRead.convertJsonAsString("successCrmLoginResponse.json"),
  override val mockEndUrl: String = "/secure/rest/sign/in/",
  override var mappingBuilder: MappingBuilder? = null
) : MockConfig