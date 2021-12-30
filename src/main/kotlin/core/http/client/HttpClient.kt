package core.http.client

import core.http.response.HttpClientResponse

interface HttpClient {
  fun getClient(): Any
  fun makeGetRequest(url: String): HttpClientResponse
}