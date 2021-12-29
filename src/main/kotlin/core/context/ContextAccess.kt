package core.context

import core.api.crm.controller.CrmController
import core.context.dynamic.DynamicContextHolder
import core.context.dynamic.SessionContext
import core.http.response.HttpClientResponse

val sessionContext: () -> SessionContext = {
  DynamicContextHolder.getConfig().sessionContext
}

val httpClientResponse: () -> HttpClientResponse = {
  CrmController().authCrm()
}