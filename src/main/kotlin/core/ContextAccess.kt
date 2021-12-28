package core

import core.holder.dynamicContext.DynamicContextHolder
import core.holder.staticContext.StaticContextHolder
import core.model.ApplicationConfig
import core.observer.SessionContext

val staticContextConfig: () -> ApplicationConfig = {
  StaticContextHolder.getConfig()
}

val sessionContext: () -> SessionContext = {
  DynamicContextHolder.getConfig().sessionContext
}