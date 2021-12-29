package core

import core.api.crm.controller.CrmController
import core.context.constant.ApplicationConfig
import core.context.constant.StaticContextHolder
import core.context.dynamic.DynamicContextHolder
import core.context.dynamic.SessionContext
import core.http.response.HttpClientResponse

val staticContextConfig: () -> ApplicationConfig = {
  StaticContextHolder.getConfig()
}

val sessionContext: () -> SessionContext = {
  DynamicContextHolder.getConfig().sessionContext
}

val httpClientResponse: () -> HttpClientResponse = {
  CrmController().authCrm()
}