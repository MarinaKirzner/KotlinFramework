package core.api.crm.service

import core.api.crm.model.CrmUserRequest
import core.api.crm.model.CrmUserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface CrmService {
  @POST("/secure/rest/sign/in/")
  fun postCrmUserConfig(@Body crmUserRequest: CrmUserRequest): Call<CrmUserResponse>
}