package step

import core.holder.StaticContextHolder

class RegistrationPageSteps {

  val registrationUrl: String = StaticContextHolder.getConfig().run {
    getUrlWithSelectedEndpoint(registrationEndPoint)
  }
}