package core.holder

import core.model.ApplicationConfig

object StaticContextHolder : ContextHolder {
  var applicationConfig: ApplicationConfig? = null

  override fun getConfig(): ApplicationConfig {
    return applicationConfig ?: throw IllegalStateException("Context not initialisation")
  }

  override fun clearContext() {
    applicationConfig == null
  }
}