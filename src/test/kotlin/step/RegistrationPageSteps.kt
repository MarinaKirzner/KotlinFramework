package step

import core.holder.staticContext.StaticContextHolder

class RegistrationPageSteps {

  val registrationUrl: String = StaticContextHolder.getConfig().run {
    getUrlWithSelectedEndpoint(registrationEndPoint)
  }
}