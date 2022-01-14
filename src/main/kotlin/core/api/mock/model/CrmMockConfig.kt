package core.api.mock.model

import core.reader.JsonFileRead

data class CrmMockConfig(
  override val priority: Int = 1,
  override val mockName: String = "LoggingToCrmStub",
  override val statusCode: Int = 200,
  override val header: Map<String, String> = mapOf("Set-Cookie" to "AuthUser=eyJhbGciOiJIUzUxMiJ9"),
  override val body: String? = JsonFileRead.convertJsonAsString()
) : MockConfig