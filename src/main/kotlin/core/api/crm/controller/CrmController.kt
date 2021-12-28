package core.api.crm.controller

import core.api.crm.builder.CrmUserRequestBuilder
import core.api.crm.model.CrmUserRequest
import core.api.crm.model.CrmUserResponse
import core.api.crm.service.CrmService
import core.http.response.ResponseHttpClient
import core.http.retrofit.RetrofitServiceBuilder
import core.sessionContext
import retrofit2.Call
import retrofit2.Response

class CrmController {

  private val crmUserRequest: CrmUserRequest = CrmUserRequestBuilder().addCrmUserRequestConfig()
  private val crmUserService: CrmService = RetrofitServiceBuilder().buildService(serviceClass = CrmService::class.java)

  fun authCrm(): ResponseHttpClient {
    val callCrmUser: Call<CrmUserResponse> = crmUserService.postCrmUserConfig(crmUserRequest)
    val postResponse: Response<CrmUserResponse> = callCrmUser.execute()
    val responseHttpClient = ResponseHttpClient(postResponse.raw())
    sessionContext().sessionResponse = responseHttpClient
    return responseHttpClient
  }
}