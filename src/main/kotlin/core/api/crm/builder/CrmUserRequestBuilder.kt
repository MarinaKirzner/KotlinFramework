package core.api.crm.builder

import core.api.crm.model.CrmUserRequest
import core.staticContextConfig

class CrmUserRequestBuilder {
  fun addCrmUserRequestConfig(): CrmUserRequest {
    val configRequest: CrmUserRequest = with(staticContextConfig().crmUserConfig) {
      CrmUserRequest(login, password, captcha)
    }
    return configRequest
  }
}