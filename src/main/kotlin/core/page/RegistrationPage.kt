import core.holder.StaticContextHolder

class RegistrationPage {

  val registrationUrl: String = StaticContextHolder.getConfig().run {
    getUrlWithSelectedEndpointWithBasicAuth(registrationUrl)
  }
}