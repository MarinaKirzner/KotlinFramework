package core.context.dynamic

import core.context.TafContextHolder

object DynamicContextHolder : TafContextHolder<DynamicContext> {
  override var context: DynamicContext? = null
}