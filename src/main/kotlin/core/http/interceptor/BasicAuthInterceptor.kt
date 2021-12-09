package core.http.interceptor

import core.model.ApplicationConfig
import core.provider.ApplicationConfigProvider
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response

class BasicAuthInterceptor : Interceptor {

  val applicationConfig: ApplicationConfig = ApplicationConfigProvider().getApplicationConfig()

  override fun intercept(chain: Interceptor.Chain): Response {
    val request: Request = chain.request()
    val authRequest: Request = request.newBuilder().header(applicationConfig.user, applicationConfig.pass).build()
    return chain.proceed(authRequest)
  }
}