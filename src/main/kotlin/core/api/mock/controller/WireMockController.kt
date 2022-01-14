package core.api.mock.controller

import core.api.mock.service.MockService

class WireMockController() {
  fun setUpMock() = MockService().raiseStub()
  fun deleteMock() = MockService().removeStub()
}