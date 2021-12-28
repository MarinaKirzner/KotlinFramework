package core.holder

interface ContextHolder {
  fun clearContext()
  fun getConfig(): ContextType
}