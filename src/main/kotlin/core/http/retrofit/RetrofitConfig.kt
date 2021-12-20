package core.http.retrofit

import core.holder.StaticContextHolder
import core.http.httpClient.IntegrationHttpClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig() {
  private val okHttpClient: OkHttpClient = IntegrationHttpClient().getClient()

  val retrofit: Retrofit = Retrofit.Builder()
    .client(okHttpClient)
    .baseUrl(StaticContextHolder.getConfig().getBaseUrl())
    .addConverterFactory(GsonConverterFactory.create())
    .build()
}