package core.holder.dynamicContext

import core.http.response.ResponseHttpClient

class SessionContext {
  var serviceResponse: ResponseHttpClient? = null
  var dynamicCookieValue: String? = null
}