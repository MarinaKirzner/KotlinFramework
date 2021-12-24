package core.holder.dynamicContext

interface DynamicHolder {
  fun getDynamicConfig(): DynamicContext
  fun clearContext()
}