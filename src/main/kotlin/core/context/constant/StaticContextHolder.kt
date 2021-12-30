package core.context.constant

import core.context.TafContextHolder

object StaticContextHolder : TafContextHolder<ApplicationConfig> {
  override var context: ApplicationConfig? = null
}