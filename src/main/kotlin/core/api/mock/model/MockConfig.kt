package core.api.mock.model

interface MockConfig {
  val priority: Int
  val mockName: String
  val statusCode: Int
  val header: Map<String, String>
  val body: String?
  val mockEndUrl: String
}