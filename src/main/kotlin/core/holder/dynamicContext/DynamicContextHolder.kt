package core.holder.dynamicContext

object DynamicContextHolder : DynamicHolder {

  var dynamicContext: DynamicContext? = null

  override fun getDynamicConfig(): DynamicContext {
    return dynamicContext ?: throw IllegalStateException("Context not initialisation")
  }

  override fun clearContext() {
    dynamicContext == null
  }
}