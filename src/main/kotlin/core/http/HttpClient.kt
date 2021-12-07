package core.http

import okhttp3.Response

interface HttpClient {
  fun getClient(): Any
  fun makeGetRequest(url: String) : String
}