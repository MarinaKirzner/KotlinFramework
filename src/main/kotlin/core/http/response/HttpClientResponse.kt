package core.http.response

import okhttp3.Headers
import okhttp3.Response

class HttpClientResponse(val response: Response) {

  val cookieHeaderName = "Set-Cookie"
  private val delimiter = ";"
  private val equal = "="

  private fun getHeaders(): Headers {
    return response.headers
  }

  private fun getHeader(headerName: String): String? {
    return response.headers[headerName]
  }

  fun getCookie(): String? = getHeader(cookieHeaderName)

  fun getValueFromCookies(cookieName: String): String? {
    var cookieValue: String? = null
    val cookies: String? = getHeaders().get(cookieHeaderName)
    cookies?.apply {
      val cookiesList: List<String> = cookies.split(delimiter).map { it.trim() }
      val cookiesMap: Map<String, String> = cookiesList.map { it.split(equal) }
        .associate { it.first() to it.last() }
      cookieValue = cookiesMap[cookieName]
    }
    return cookieValue
  }
}