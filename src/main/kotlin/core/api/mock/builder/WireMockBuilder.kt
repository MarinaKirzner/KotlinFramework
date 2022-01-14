package core.api.mock.builder

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import core.api.mock.model.CrmMockConfig
import core.context.constant.StaticContextHolder.getConfig

class WireMockBuilder(private val crmMockConfig: CrmMockConfig = CrmMockConfig()) {

  fun getStubMapping(): MappingBuilder {
    return WireMock.post(getConfig().getWireMockUrl())
      .atPriority(crmMockConfig.priority)
      .withName(crmMockConfig.mockName)
      .willReturn(
        getStubResponse()
      )
  }

  private fun getStubResponse(): ResponseDefinitionBuilder? {
    return WireMock.aResponse()
      .withStatus(crmMockConfig.statusCode)
      .withHeader("Set-Cookie", "AuthUser=eyJhbGciOiJIUzUxMiJ9")
      .withBody(crmMockConfig.body)
  }
}