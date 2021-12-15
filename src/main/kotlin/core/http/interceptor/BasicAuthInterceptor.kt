package core.http.interceptor

import core.holder.StaticContextHolder
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class BasicAuthInterceptor : Interceptor {

  val config = StaticContextHolder.getConfig()

  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()
    val authRequest: Request = request.newBuilder()
      .header(config.user, config.pass)
      .build()
    return chain.proceed(authRequest)
  }
}