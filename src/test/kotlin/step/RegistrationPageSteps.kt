package step

import core.holder.StaticContextHolder

class RegistrationPageSteps {

  val registrationUrl: String? = StaticContextHolder.applicationConfig?.run {
    getUrlWithSelectedEndpoint(registrationEndPoint)
  }
}