package core.ui.crm.model

data class IpruCrmConfig(
  val domain: String,
  val email: String,
  val pass: String,
  val registrationUrl: String,
  val crmBaseUrl: String,
  val crmClientsUrl: String
)