package core.http.httpClient

interface HttpClient {
  fun getClient(): Any
  fun makeGetRequest(url: String): ResponseHttpClient
}