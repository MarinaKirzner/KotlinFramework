package core.http.response

import okhttp3.Headers
import okhttp3.Response

class ResponseHttpClient(val response: Response) {

  private val name = "Set-Cookie"
  val delimiter = ";"
  val equal = "="

  fun getHeader(response: Response): Headers {
    return response.headers
  }

  fun getValueFromCookies(cookieName: String): String? {
    var cookieValue: String? = null
    val cookies: String? = getHeader(response).get(name)
    cookies?.apply {
      val cookiesList: List<String> = cookies.split(delimiter).map { it.trim() }
      val cookiesMap: Map<String, String> = cookiesList.map { it.split(equal) }
        .associate {
          it.first() to it.last()
        }
      cookieValue = cookiesMap.getValue(cookieName)
    }
    return cookieValue
  }
}