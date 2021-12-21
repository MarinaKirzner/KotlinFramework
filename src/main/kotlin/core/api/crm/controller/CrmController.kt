package core.api.crm.controller

import core.api.crm.builder.CrmUserRequestBuilder
import core.api.crm.model.CrmUserResponse
import core.http.response.ResponseHttpClient
import core.http.retrofit.RetrofitConfig
import retrofit2.Call

class CrmController() {
  fun authCrm(): ResponseHttpClient {
    val callUser: Call<CrmUserResponse> = RetrofitConfig().addRetrofit()
      .postCrmUserConfig(CrmUserRequestBuilder().addCrmUserRequestConfig())
    val postResponse: okhttp3.Response = callUser.execute().raw()
    return ResponseHttpClient(postResponse)
  }
}