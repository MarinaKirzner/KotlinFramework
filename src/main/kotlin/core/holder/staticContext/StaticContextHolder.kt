package core.holder.staticContext

import core.holder.TafContextHolder

import core.model.ApplicationConfig

object StaticContextHolder : TafContextHolder<ApplicationConfig> {
  override var context: ApplicationConfig? = null
}