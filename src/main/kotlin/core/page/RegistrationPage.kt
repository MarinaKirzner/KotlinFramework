import core.holder.StaticContextHolder

class RegistrationPage {

  val registrationUrl: String? = StaticContextHolder.applicationConfig?.run {
    getUrlWithSelectedEndpointWithBasicAuth(registrationUrl)
  }
}