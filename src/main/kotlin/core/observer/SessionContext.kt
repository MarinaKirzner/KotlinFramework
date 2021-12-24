package core.observer

import core.http.response.ResponseHttpClient

class SessionContext : Observable {

  var observers: ArrayList<Observer> = ArrayList()

  init {
    val sessionContextObserver: SessionContextObserver = SessionContextObserver(this)
    this.observers.add(sessionContextObserver)
  }

  var authUserCookieValue: String? = null

  var sessionResponse: ResponseHttpClient? = null
    set(value) {
      field = value
      notifyObservers()
    }

  override fun notifyObservers() {
    observers.forEach {
      it.update()
    }
  }
}