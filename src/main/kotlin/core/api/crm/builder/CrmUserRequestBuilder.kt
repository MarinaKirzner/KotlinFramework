package core.api.crm.builder

import core.api.crm.model.CrmUserRequest
import core.holder.staticContext.StaticContextHolder.getConfig

class CrmUserRequestBuilder {
  fun addCrmUserRequestConfig(): CrmUserRequest {
    val configRequest: CrmUserRequest = with(getConfig().crmUserConfig) {
      CrmUserRequest(login, password, captcha)
    }
    return configRequest
  }
}