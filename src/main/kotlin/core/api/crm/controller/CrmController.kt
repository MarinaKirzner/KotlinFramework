package core.api.crm.controller

import core.api.crm.builder.CrmUserRequestBuilder
import core.api.crm.model.CrmUserRequest
import core.api.crm.model.CrmUserResponse
import core.api.crm.service.CrmService
import core.holder.dynamicContext.DynamicContextHolder
import core.http.response.ResponseHttpClient
import core.http.retrofit.RetrofitServiceBuilder
import retrofit2.Call
import retrofit2.Response

class CrmController() {
  fun authCrm(): ResponseHttpClient {
    val crmUserRequest: CrmUserRequest = CrmUserRequestBuilder().addCrmUserRequestConfig()
    val buildCrmUserService: CrmService = RetrofitServiceBuilder().buildService(serviceClass = CrmService::class.java)
    val callCrmUser: Call<CrmUserResponse> = buildCrmUserService.postCrmUserConfig(crmUserRequest)
    val postResponse: Response<CrmUserResponse> = callCrmUser.execute()
    val responseController = ResponseHttpClient(postResponse.raw())
    DynamicContextHolder.getDynamicConfig().sessionContext.sessionResponse = responseController
    return responseController
  }
}