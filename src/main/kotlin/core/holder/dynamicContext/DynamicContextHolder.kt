package core.holder.dynamicContext

import core.holder.ContextHolder

object DynamicContextHolder : ContextHolder {

  var dynamicContext: DynamicContext? = null

  override fun getConfig(): DynamicContext {
    return dynamicContext ?: throw IllegalStateException("Context not initialisation")
  }

  override fun clearContext() {
    dynamicContext == null
  }
}