package core

import core.api.crm.controller.CrmController
import core.holder.dynamicContext.DynamicContextHolder
import core.holder.observer.SessionContext
import core.holder.staticContext.StaticContextHolder
import core.http.response.ResponseHttpClient
import core.model.ApplicationConfig

val staticContextConfig: () -> ApplicationConfig = {
  StaticContextHolder.getConfig()
}

val sessionContext: () -> SessionContext = {
  DynamicContextHolder.getConfig().sessionContext
}

val responseHttpClient: () -> ResponseHttpClient = {
  CrmController().authCrm()
}