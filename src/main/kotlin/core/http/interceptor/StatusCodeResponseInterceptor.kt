package core.http.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class StatusCodeResponseInterceptor : Interceptor {

  override fun intercept(chain: Interceptor.Chain): Response {
    val validStatusCodeRange = 200..201
    val request: Request = chain.request()
    val response: Response = chain.proceed(request)
    if (response.code in validStatusCodeRange) {
      return response
    }
    throw IllegalStateException("Unsuccessful API call. Error ${response.code}")
  }
}