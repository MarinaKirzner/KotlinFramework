package core.http.interceptor

import core.holder.StaticContextHolder
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class BasicAuthInterceptor : Interceptor {

  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()
    val authRequest: Request = request.newBuilder()
      .header(StaticContextHolder.getConfig().user, StaticContextHolder.getConfig().pass)
      .build()
    return chain.proceed(authRequest)
  }
}