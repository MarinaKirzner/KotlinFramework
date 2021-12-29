package exercise.config.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties(ignoreUnknown = true)
data class Config(
  @JsonProperty("host") val myHost: String? = null,
  val url: String? = null,
  val login: String? = null,
  val pass: String? = null,
  val ignoreNullableInModel: String? = null
)