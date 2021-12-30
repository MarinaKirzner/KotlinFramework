package core.ui.page

import core.context.constant.StaticContextHolder.getConfig

class RegistrationPage {

  val registrationUrl: String = getConfig().run {
    getUrlWithSelectedEndpointWithBasicAuth(registrationUrl)
  }
}