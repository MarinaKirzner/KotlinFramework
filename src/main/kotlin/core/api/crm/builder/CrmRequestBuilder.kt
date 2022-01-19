package core.api.crm.builder

import core.api.crm.model.CrmUserRequest
import core.context.constant.StaticContextHolder.getConfig

class CrmRequestBuilder {
  fun getCrmUserRequestBody(): CrmUserRequest {
    val configRequest: CrmUserRequest = with(getConfig().crmUserConfig) {
      CrmUserRequest(login, password, captcha)
    }
    return configRequest
  }
}