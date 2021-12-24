package core.api.crm.model

data class CrmUserRequest(
  val login: String,
  val password: String,
  val captcha: String
)