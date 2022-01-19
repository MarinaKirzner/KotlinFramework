package core.api.mock.model

import com.github.tomakehurst.wiremock.client.MappingBuilder
import java.util.*

interface MockConfig {
  var uuid: UUID?
  val priority: Int
  val mockName: String
  val statusCode: Int
  val header: Map<String, String>
  val body: String?
  val mockEndUrl: String
  val mappingBuilder: MappingBuilder?
}