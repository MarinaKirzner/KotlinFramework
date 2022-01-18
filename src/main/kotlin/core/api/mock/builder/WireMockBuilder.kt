package core.api.mock.builder

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import core.api.mock.model.CrmMockConfig
import core.context.constant.StaticContextHolder.getConfig

class WireMockBuilder {

  fun getStubMapping(crmMockConfig: CrmMockConfig): MappingBuilder {
    return WireMock.post(getConfig().getWireMockUrl())
      .atPriority(crmMockConfig.priority)
      .withName(crmMockConfig.mockName)
      .willReturn(
        getStubResponse(crmMockConfig)
      )
  }

  private fun getStubResponse(crmMockConfig: CrmMockConfig): ResponseDefinitionBuilder? {
    return WireMock.aResponse()
      .withStatus(crmMockConfig.statusCode)
      .withBody(crmMockConfig.body)
      .withHeader(crmMockConfig.header.keys.toString(), crmMockConfig.header.values.toString())
  }
}