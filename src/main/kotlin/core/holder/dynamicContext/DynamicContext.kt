package core.holder.dynamicContext

import core.holder.observer.SessionContext

class DynamicContext {
  val sessionContext: SessionContext by lazy { SessionContext() }
}