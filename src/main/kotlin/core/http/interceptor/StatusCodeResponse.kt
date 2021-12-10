package core.http.interceptor

import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class StatusCodeResponse() : Interceptor {

  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()
    val response: Response = chain.proceed(request)
    if (response.code == 200 || response.code == 201) {
      return response
    }
    throw IOException("Unsuccessful API call. Error ${response.code}")
  }
}