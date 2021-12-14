package core.http.httpClient

import core.http.interceptor.BasicAuthInterceptor
import core.http.interceptor.BaseLoggerInterceptor
import core.http.interceptor.StatusCodeResponse
import core.http.response.ResponseHttpClient
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response

class IntegrationHttpClient : HttpClient {

  private val client: OkHttpClient = OkHttpClient().newBuilder()
    .addInterceptor(BasicAuthInterceptor())
    .addInterceptor(StatusCodeResponse())
    .addInterceptor(BaseLoggerInterceptor())
    .build()

  override fun getClient(): OkHttpClient {
    return client
  }

  override fun makeGetRequest(url: String?): ResponseHttpClient {
    val request: Request = Request.Builder().get().url(url.toString()).build()
    val response: Response = getClient().newCall(request).execute()
    return ResponseHttpClient(response)
  }
}