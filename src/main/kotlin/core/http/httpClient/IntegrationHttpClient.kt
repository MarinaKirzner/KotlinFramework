package core.http.httpClient

import core.http.interceptor.BasicAuthInterceptor
import core.http.interceptor.StatusCodeResponse
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

class IntegrationHttpClient : HttpClient {

  var logger: HttpLoggingInterceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
  private val client: OkHttpClient = OkHttpClient().newBuilder()
    .addInterceptor(logger)
    .addInterceptor(StatusCodeResponse())
    .addInterceptor(BasicAuthInterceptor())
    .build()

  override fun getClient(): OkHttpClient {
    return client
  }

  override fun makeGetRequest(url: String): ResponseHttpClient {
    val request: Request = Request.Builder().url(url).build()
    val response: Response = getClient().newCall(request).execute()
    return ResponseHttpClient(response)
  }
}