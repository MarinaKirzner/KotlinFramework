import core.holder.staticContext.StaticContextHolder

class RegistrationPage {

  val registrationUrl: String = StaticContextHolder.getConfig().run {
    getUrlWithSelectedEndpointWithBasicAuth(registrationUrl)
  }
}