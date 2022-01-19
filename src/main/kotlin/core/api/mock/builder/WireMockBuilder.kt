package core.api.mock.builder

import com.github.tomakehurst.wiremock.client.MappingBuilder
import com.github.tomakehurst.wiremock.client.ResponseDefinitionBuilder
import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import core.api.mock.model.CrmMockConfig

class WireMockBuilder {

  fun getStubMapping(crmMockConfig: CrmMockConfig): MappingBuilder {
    return WireMock.any(urlEqualTo(crmMockConfig.mockEndUrl))
      .atPriority(crmMockConfig.priority)
      .withName(crmMockConfig.mockName)
      .willReturn(
        getStubResponse(crmMockConfig)
      )
  }

  private fun getStubResponse(crmMockConfig: CrmMockConfig): ResponseDefinitionBuilder? {
    val builder = WireMock.aResponse()
      .withStatus(crmMockConfig.statusCode)
      .withBody(crmMockConfig.body)
      crmMockConfig.header.forEach{ builder.withHeader(it.key, it.value) }
    return builder
  }
}