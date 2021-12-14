package core.model

data class ApplicationConfig(
  var user: String,
  var pass: String,
  val host: String,
  val registrationUrl: String,
  val registrationEndPoint: String
) {

  companion object {
    private const val PROTOCOL_HTTPS = "https://"
  }

  fun getUrlWithSelectedEndpointWithBasicAuth(urlEndpoint: String) = "${getBaseUrlWithAuth()}${urlEndpoint}"

  fun getUrlWithSelectedEndpoint(urlEndpoint: String): String {
    val urlRegistrationEndpoint = "$PROTOCOL_HTTPS${host}${urlEndpoint}"
    return urlRegistrationEndpoint
  }

  fun getBaseUrlWithAuth(): String {
    val urlWithAuthentication = "$PROTOCOL_HTTPS${user}:${pass}@${host}"
    return urlWithAuthentication
  }

  fun getBaseUrl(): String {
    val urlWithAuthentication = "$PROTOCOL_HTTPS${host}"
    return urlWithAuthentication
  }
}
