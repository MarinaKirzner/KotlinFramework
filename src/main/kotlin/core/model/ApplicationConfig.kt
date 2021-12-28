package core.model

import core.holder.ContextType

data class ApplicationConfig(
  var user: String,
  var pass: String,
  val host: String,
  val registrationUrl: String,
  val registrationEndPoint: String,
  val crmUserConfig: CrmUserConfig
) : ContextType {
  companion object {
    private const val PROTOCOL_HTTPS = "https://"
  }

  fun getUrlWithSelectedEndpointWithBasicAuth(urlEndpoint: String) = "${getBaseUrlWithAuth()}${urlEndpoint}"

  fun getUrlWithSelectedEndpoint(urlEndpoint: String) = "$PROTOCOL_HTTPS${host}${urlEndpoint}"

  fun getBaseUrlWithAuth() = "$PROTOCOL_HTTPS${user}:${pass}@${host}"

  fun getBaseUrl() = "$PROTOCOL_HTTPS${host}"
}
