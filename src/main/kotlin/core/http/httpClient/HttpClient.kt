package core.http.httpClient

import core.http.response.ResponseHttpClient

interface HttpClient {
  fun getClient(): Any
  fun makeGetRequest(url: String?): ResponseHttpClient
}