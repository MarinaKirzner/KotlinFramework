package core.context

interface TafContextHolder<T : TafContext> {

  var context: T?

  fun getConfig(): T {
    return context ?: throw IllegalStateException("Context not initialisation")
  }

  fun clearContext() {
    context = null
  }
}