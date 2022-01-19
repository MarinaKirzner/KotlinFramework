package core.api.mock.controller

import core.api.mock.model.CrmMockConfig
import core.api.mock.service.MockService

class WireMockController(
  private val mockService: MockService = MockService()
) {
  fun setUpMock(crmMockConfig: CrmMockConfig) = mockService.raiseStub(crmMockConfig)
  fun deleteMock(crmMockConfig: CrmMockConfig) = mockService.removeStub(crmMockConfig)
}