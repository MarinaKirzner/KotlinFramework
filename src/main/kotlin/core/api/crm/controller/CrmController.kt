package core.api.crm.controller

import core.api.crm.builder.CrmUserRequestBuilder
import core.api.crm.model.CrmUserRequest
import core.api.crm.model.CrmUserResponse
import core.api.crm.service.CrmService
import core.http.response.HttpClientResponse
import core.retrofit.RetrofitServiceBuilder
import core.sessionContext
import retrofit2.Call
import retrofit2.Response

class CrmController {

  private val crmUserRequest: CrmUserRequest = CrmUserRequestBuilder().addCrmUserRequestConfig()
  private val crmUserService: CrmService = RetrofitServiceBuilder().buildService(serviceClass = CrmService::class.java)

  fun authCrm(): HttpClientResponse {
    val callCrmUser: Call<CrmUserResponse> = crmUserService.postCrmUserConfig(crmUserRequest)
    val postResponse: Response<CrmUserResponse> = callCrmUser.execute()
    val httpClientResponse = HttpClientResponse(postResponse.raw())
    sessionContext().sessionResponse = httpClientResponse
    return httpClientResponse
  }
}