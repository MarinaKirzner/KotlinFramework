package core.retrofit

import core.http.client.IntegrationHttpClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitServiceBuilder {
  private val okHttpClient: OkHttpClient = IntegrationHttpClient().getClient()

  fun <T> buildService(baseUrl: String, serviceClass: Class<T>): T {
    val retrofit: Retrofit = Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl(baseUrl)
      .addConverterFactory(GsonConverterFactory.create())
      .build()
    return retrofit.create(serviceClass)
  }
}