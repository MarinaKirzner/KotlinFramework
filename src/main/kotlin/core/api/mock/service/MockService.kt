package core.api.mock.service

import com.github.tomakehurst.wiremock.client.WireMock
import com.github.tomakehurst.wiremock.client.WireMock.postRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.urlEqualTo
import com.github.tomakehurst.wiremock.client.WireMock.verify
import core.api.mock.builder.WireMockBuilder
import core.api.mock.model.CrmMockConfig
import core.context.wireMockConfig

class MockService {

  private val wireMockBuilder: WireMockBuilder = WireMockBuilder()
  private val wireMockClient: WireMock = WireMock(wireMockConfig.host, wireMockConfig.port)

  fun raiseStub(crmMockConfig: CrmMockConfig) {
    crmMockConfig.mappingBuilder = wireMockBuilder.getStubMapping(crmMockConfig)
    wireMockClient.register(crmMockConfig.mappingBuilder)
    verifyStub(crmMockConfig)
  }

  private fun verifyStub(crmMockConfig: CrmMockConfig) {
    verify((postRequestedFor(urlEqualTo(crmMockConfig.mockEndUrl))
      .withPort(wireMockConfig.port)))
  }

  fun removeStub(crmMockConfig: CrmMockConfig) = WireMock.removeStub(crmMockConfig.mappingBuilder)
}