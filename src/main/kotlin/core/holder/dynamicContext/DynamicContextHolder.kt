package core.holder.dynamicContext

import core.holder.TafContextHolder

object DynamicContextHolder : TafContextHolder<DynamicContext> {
  override var context: DynamicContext? = null
}