package core.context.dynamic

import core.context.observer.Observable
import core.context.observer.Observer
import core.context.observer.SessionContextObserver
import core.http.response.HttpClientResponse

class SessionContext : Observable {

  var observers: ArrayList<Observer> = ArrayList()

  init {
    val sessionContextObserver: SessionContextObserver = SessionContextObserver(this)
    this.observers.add(sessionContextObserver)
  }

  var authUserCookieValue: String? = null

  var sessionResponse: HttpClientResponse? = null
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