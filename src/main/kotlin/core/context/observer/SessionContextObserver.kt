package core.context.observer

import core.context.dynamic.SessionContext

class SessionContextObserver(val sessionContext: SessionContext) : Observer {

  private val authUserCookieName = "AuthUser"

  override fun update() {
    val sessionAuthUser: String? = sessionContext.sessionResponse?.getValueFromCookies(authUserCookieName)
    sessionAuthUser.let {
      sessionContext.authUserCookieValue = sessionAuthUser
    }
  }
}