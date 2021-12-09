package core.model

data class ApplicationConfig(
  var user: String,
  var pass: String,
  val host: String,
  val registrationEndpoint: String
) {
  fun getHostUrl(): String {
    val host = "https://$host"
    return host
  }

  fun getHostWithBasicAuth(): String {
    val registrationEndpoint = "https://${user}:${pass}@${host}${registrationEndpoint}"
    return registrationEndpoint
  }
}
