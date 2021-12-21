package core.http.retrofit

import core.api.crm.service.CrmService
import core.holder.staticContext.StaticContextHolder
import core.http.httpClient.IntegrationHttpClient
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitConfig {
  private val okHttpClient: OkHttpClient = IntegrationHttpClient().getClient()

  fun addRetrofit(): CrmService {
    val retrofit: Retrofit = Retrofit.Builder()
      .client(okHttpClient)
      .baseUrl(StaticContextHolder.getConfig().getBaseUrl())
      .addConverterFactory(GsonConverterFactory.create())
      .build()
    val service: CrmService = retrofit.create(CrmService::class.java)
    return service
  }
}