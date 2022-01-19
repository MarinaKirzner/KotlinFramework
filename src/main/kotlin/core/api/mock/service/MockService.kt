package core.api.mock.service

import com.github.tomakehurst.wiremock.client.WireMock
import core.api.mock.builder.WireMockBuilder
import core.api.mock.model.CrmMockConfig
import core.context.wireMockConfig

class MockService {

  private val wireMockBuilder: WireMockBuilder = WireMockBuilder()
  private val wireMockClient: WireMock = WireMock(wireMockConfig.host, wireMockConfig.port)

  fun raiseStub(crmMockConfig: CrmMockConfig) {
    crmMockConfig.mappingBuilder = wireMockBuilder.getStubMapping(crmMockConfig)
    wireMockClient.register(crmMockConfig.mappingBuilder).apply {
      crmMockConfig.uuid = this.uuid
    }
    verifyStub(crmMockConfig)
  }

  private fun verifyStub(crmMockConfig: CrmMockConfig) {
    wireMockClient.getStubMapping(crmMockConfig.uuid) ?: IllegalArgumentException("Don't raise stub")
  }

  fun removeStub(crmMockConfig: CrmMockConfig) = WireMock.removeStub(crmMockConfig.mappingBuilder)
}