package core.holder.dynamicContext

import core.holder.ContextType
import core.observer.SessionContext

class DynamicContext: ContextType {
  val sessionContext: SessionContext by lazy { SessionContext() }
}