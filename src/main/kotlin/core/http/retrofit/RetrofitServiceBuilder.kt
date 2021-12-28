package core.http.retrofit

import core.http.httpClient.IntegrationHttpClient
import core.staticContextConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServiceBuilder {
  private val okHttpClient: OkHttpClient = IntegrationHttpClient().getClient()

  fun <T> buildService(baseUrl: String = staticContextConfig().getBaseUrl(), serviceClass: Class<T>): T {
    val retrofit: Retrofit = Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
    val service: T = retrofit.create(serviceClass)
    return service
  }
}