package core.http.httpClient

import okhttp3.Headers
import okhttp3.Response

class ResponseHttpClient(response: Response) {

  val response: Response = response
  private val name = "Set-Cookie"
  val delimiter = ";"
  val equal = "="

  fun getHeader(response: Response): Headers {
    return response.headers
  }

  fun getValueFromCookies(cookieName: String): String? {
    val cookies: String? = getHeader(response).get(name)
    cookies.apply {
      val cookiesList: List<String> = cookies!!.split(delimiter).map { it.trim() }
      val cookiesMap: Map<String, String> = cookiesList.map { it.split(equal) }
        .associate {
          it.first() to it.last()
        }
      return cookiesMap.getValue(cookieName)
    }
  }
}