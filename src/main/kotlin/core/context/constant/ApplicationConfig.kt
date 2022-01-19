package core.context.constant

import core.api.mock.model.WireMockConfig
import core.context.TafContext

data class ApplicationConfig(
  var user: String,
  var pass: String,
  val host: String,
  val registrationUrl: String,
  val registrationEndPoint: String,
  val crmUserConfig: CrmUserConfig,
  val wireMockConfig: WireMockConfig
) : TafContext {
  companion object {
    private const val PROTOCOL_HTTPS = "https://"
    private const val PROTOCOL_HTTP = "http://"
  }

  fun getUrlWithSelectedEndpointWithBasicAuth(urlEndpoint: String) = "${getBaseUrlWithAuth()}${urlEndpoint}"

  fun getUrlWithSelectedEndpoint(urlEndpoint: String) = "$PROTOCOL_HTTPS${host}${urlEndpoint}"

  fun getBaseUrlWithAuth() = "$PROTOCOL_HTTPS${user}:${pass}@${host}"

  fun getBaseUrl() = "$PROTOCOL_HTTPS${host}"

  fun getWireMockUrl() = "$PROTOCOL_HTTP${wireMockConfig.host}:${wireMockConfig.port}"
}