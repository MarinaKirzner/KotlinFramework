package core.context.constant

import core.api.mock.model.WireMockConfig
import core.context.TafContext
import core.db.model.DbConnectionConfig
import core.ui.crm.model.IpruCrmConfig

data class ApplicationConfig(
  var user: String,
  var pass: String,
  val host: String,
  val registrationUrl: String,
  val registrationEndPoint: String,
  val crmUserConfig: CrmUserConfig,
  val wireMockConfig: WireMockConfig,
  val dbConnectionConfig: DbConnectionConfig,
  val ipruCrmConfig: IpruCrmConfig,
  val crmLoginUrl: String,
  val crmBaseUrl: String,
  val crmClientsUrl: String
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

  fun getCrmDomainUrl() = "$PROTOCOL_HTTPS${ipruCrmConfig.domain}"

  fun getCrmEndpointUrl(crmUrlEndpoint: String) = "${getCrmDomainUrl()}$crmUrlEndpoint"
}