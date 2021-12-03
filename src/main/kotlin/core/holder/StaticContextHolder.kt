package core.holder

import core.model.ApplicationConfig

object StaticContextHolder : ContextHolder {
  var applicationConfig: ApplicationConfig? = null

  override fun clearContext() {
    applicationConfig == null
  }
}