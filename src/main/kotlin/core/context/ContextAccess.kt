package core.context

import core.api.mock.model.WireMockConfig
import core.context.constant.StaticContextHolder
import core.context.dynamic.DynamicContextHolder
import core.context.dynamic.SessionContext

val sessionContext: SessionContext = DynamicContextHolder.getConfig().sessionContext
val wireMockConfig: WireMockConfig = StaticContextHolder.getConfig().wireMockConfig