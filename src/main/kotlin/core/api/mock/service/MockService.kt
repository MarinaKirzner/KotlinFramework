package core.api.mock.service

import com.github.tomakehurst.wiremock.client.WireMock
import core.api.mock.builder.WireMockBuilder
import core.context.constant.StaticContextHolder.getConfig

class MockService {
  private val wireMockClient = WireMock(getConfig().wireMockConfig.host, getConfig().wireMockConfig.port)

  fun raiseStub() {
    wireMockClient.register(WireMockBuilder().getStubMapping())
  }

  fun removeStub() {
    WireMock.delete(getConfig().getWireMockUrl())
  }
}