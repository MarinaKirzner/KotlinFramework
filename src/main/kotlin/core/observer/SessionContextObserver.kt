package core.observer

class SessionContextObserver(val sessionContext: SessionContext) : Observer {

  private val authUserCookieName = "AuthUser"

  override fun update() {
    val sessionAuthUser = sessionContext.sessionResponse?.getValueFromCookies(authUserCookieName)
    if (sessionAuthUser != null) {
      sessionContext.authUserValue = sessionAuthUser
    }
  }
}