package core.context.observer

import core.context.dynamic.SessionContext
import core.sessionContext

class SessionContextObserver(val sessionContext: SessionContext) : Observer {

  private val authUserCookieName = "AuthUser"

  override fun update() {
    val sessionAuthUser: String? = sessionContext().sessionResponse?.getValueFromCookies(authUserCookieName)
    sessionAuthUser.let {
      sessionContext.authUserCookieValue = sessionAuthUser
    }
  }
}