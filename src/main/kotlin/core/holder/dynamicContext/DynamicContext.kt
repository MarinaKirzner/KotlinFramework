package core.holder.dynamicContext

import core.holder.TafContext
import core.holder.observer.SessionContext

class DynamicContext : TafContext {
  val sessionContext: SessionContext by lazy { SessionContext() }
}