package core.api.crm.model

import core.holder.StaticContextHolder
import core.model.CrmUserConfig

data class CrmUserRequest(
  val login: String,
  val password: String,
  val captcha: String
)