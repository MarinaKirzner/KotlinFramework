package core.context

import core.context.dynamic.DynamicContextHolder
import core.context.dynamic.SessionContext

val sessionContext: SessionContext = DynamicContextHolder.getConfig().sessionContext