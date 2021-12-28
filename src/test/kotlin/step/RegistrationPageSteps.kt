package step

import core.staticContextConfig

class RegistrationPageSteps {

  val registrationUrl: String = staticContextConfig().run {
    getUrlWithSelectedEndpoint(registrationEndPoint)
  }
}