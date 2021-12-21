package core.observer

import core.holder.dynamicContext.SessionContext
import java.util.*

class ObserverCookieValue: Observable() {
  fun setCookie() {
    var newCookieValue: String? = SessionContext().dynamicCookieValue
    setChanged()
    notifyObservers(newCookieValue)
  }
}