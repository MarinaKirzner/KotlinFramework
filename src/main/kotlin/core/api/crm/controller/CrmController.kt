package core.api.crm.controller

import core.api.crm.model.CrmUserResponse
import core.api.crm.service.CrmService
import core.holder.StaticContextHolder
import core.http.response.ResponseHttpClient
import core.http.retrofit.RetrofitConfig
import retrofit2.Call

class CrmController() {
  private val service: CrmService = RetrofitConfig().retrofit.create(CrmService::class.java)

  fun authCrm(): ResponseHttpClient {
    val callAuthUser: Call<CrmUserResponse> = service
      .postCrmUserConfig(StaticContextHolder.getConfig().crmUserConfig)
    val postAuthUser: okhttp3.Response = callAuthUser.execute().raw()
    return ResponseHttpClient(postAuthUser)
  }
}