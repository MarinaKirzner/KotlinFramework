package services.page

import core.context.constant.StaticContextHolder.getConfig

class RegistrationPageSteps {

  val registrationUrl: String = getConfig().run {
    getUrlWithSelectedEndpoint(registrationEndPoint)
  }
}