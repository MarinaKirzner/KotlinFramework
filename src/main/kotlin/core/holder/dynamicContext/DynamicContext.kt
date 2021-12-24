package core.holder.dynamicContext

import core.observer.SessionContext

class DynamicContext {
  val sessionContext: SessionContext by lazy { SessionContext() }
}