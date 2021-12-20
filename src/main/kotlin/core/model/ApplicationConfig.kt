package core.model

import core.api.crm.model.CrmUserRequest

data class ApplicationConfig(
  var user: String,
  var pass: String,
  val host: String,
  val registrationUrl: String,
  val registrationEndPoint: String,
  val crmUserConfig: CrmUserRequest
) {
  companion object {
    private const val PROTOCOL_HTTPS = "https://"
  }

  fun getUrlWithSelectedEndpointWithBasicAuth(urlEndpoint: String) = "${getBaseUrlWithAuth()}${urlEndpoint}"

  fun getUrlWithSelectedEndpoint(urlEndpoint: String) = "$PROTOCOL_HTTPS${host}${urlEndpoint}"

  fun getBaseUrlWithAuth() = "$PROTOCOL_HTTPS${user}:${pass}@${host}"

  fun getBaseUrl() = "$PROTOCOL_HTTPS${host}"
}
