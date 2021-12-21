package core.holder.staticContext

import core.model.ApplicationConfig

interface ContextHolder {
  fun clearContext()
  fun getConfig(): ApplicationConfig
}