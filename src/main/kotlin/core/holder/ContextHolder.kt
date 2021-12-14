package core.holder

import core.model.ApplicationConfig

interface ContextHolder {
  fun clearContext()
  fun getConfig(): ApplicationConfig
}