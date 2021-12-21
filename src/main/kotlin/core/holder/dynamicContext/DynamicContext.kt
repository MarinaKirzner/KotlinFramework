package core.holder.dynamicContext

class DynamicContext {
  val sessionContext: SessionContext by lazy { SessionContext() }
}