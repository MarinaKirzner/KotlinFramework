package core.http

import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.IOException

class IntegrationHttpClient : HttpClient {

  private val client = OkHttpClient()

  override fun getClient(): OkHttpClient {
    return client
  }

  override fun makeGetRequest(url: String): String {
    val request = Request.Builder().url(url).build()
    val response = getClient().newCall(request).execute()
    response.use { codeResponse ->
      if (!codeResponse.isSuccessful) throw IOException("Unexpected code $codeResponse")
    }
    val cookies = response.headers.get("Set-Cookie").toString()
    return cookies
  }
}