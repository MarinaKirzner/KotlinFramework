package core.api.crm.controller

import core.api.crm.builder.CrmRequestBuilder
import core.api.crm.model.CrmUserRequest
import core.api.crm.model.CrmUserResponse
import core.api.crm.service.CrmService
import core.context.constant.StaticContextHolder
import core.context.sessionContext
import core.http.response.HttpClientResponse
import core.retrofit.RetrofitServiceBuilder
import retrofit2.Response

class CrmController(
  baseUrl: String = StaticContextHolder.getConfig().getBaseUrl(),
  private val crmUserService: CrmService = RetrofitServiceBuilder().buildService(baseUrl, CrmService::class.java),
  private val crmRequestBuilder: CrmRequestBuilder = CrmRequestBuilder()
) {
  fun authCrm(): HttpClientResponse {
    val crmUserRequest: CrmUserRequest = crmRequestBuilder.getCrmUserRequestBody()
    val postResponse: Response<CrmUserResponse> = crmUserService.postCrmUserConfig(crmUserRequest).execute()
    return HttpClientResponse(postResponse.raw()).also { sessionContext.sessionResponse = it }
  }
}