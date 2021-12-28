package core.http.httpClient

import core.http.interceptor.BasicAuthInterceptor
import core.http.interceptor.StatusCodeResponse
import core.http.interceptor.TafLoggerInterceptor
import core.http.response.ResponseHttpClient
import core.staticContextConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class IntegrationHttpClient : HttpClient {

  private val pass: String = staticContextConfig().pass
  private val user: String = staticContextConfig().user

  private val client: OkHttpClient = OkHttpClient().newBuilder()
    .addInterceptor(BasicAuthInterceptor(user, pass))
    .addInterceptor(StatusCodeResponse())
    .addInterceptor(TafLoggerInterceptor())
    .build()

  override fun getClient(): OkHttpClient {
    return client
  }

  override fun makeGetRequest(url: String): ResponseHttpClient {
    val request: Request = Request.Builder().get().url(url.toString()).build()
    val response: Response = getClient().newCall(request).execute()
    return ResponseHttpClient(response)
  }
}