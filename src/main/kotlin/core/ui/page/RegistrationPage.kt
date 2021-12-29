import core.staticContextConfig

class RegistrationPage {

  val registrationUrl: String = staticContextConfig().run {
    getUrlWithSelectedEndpointWithBasicAuth(registrationUrl)
  }
}