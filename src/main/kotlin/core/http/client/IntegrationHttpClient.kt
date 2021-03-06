package core.http.client

import core.context.constant.StaticContextHolder.getConfig
import core.http.interceptor.BasicAuthInterceptor
import core.http.interceptor.StatusCodeResponseInterceptor
import core.http.interceptor.TafLoggerInterceptor
import core.http.response.HttpClientResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class IntegrationHttpClient : HttpClient {

  private val pass: String = getConfig().pass
  private val user: String = getConfig().user

  private val client: OkHttpClient = OkHttpClient().newBuilder()
    .addInterceptor(BasicAuthInterceptor(user, pass))
    .addInterceptor(StatusCodeResponseInterceptor())
    .addInterceptor(TafLoggerInterceptor())
    .build()

  override fun getClient(): OkHttpClient {
    return client
  }

  override fun makeGetRequest(url: String): HttpClientResponse {
    val request: Request = Request.Builder().get().url(url).build()
    val response: Response = getClient().newCall(request).execute()
    return HttpClientResponse(response)
  }
}