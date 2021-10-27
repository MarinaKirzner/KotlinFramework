package config.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty

@JsonIgnoreProperties("ignoreName")
data class Config(
  @get:JsonProperty("host") val myHost: String? = null,
  val url: String? = null,
  val login: String? = null,
  val pass: String? = null,
  @JsonIgnore val ignoreNullableInModel: String? = "NOT_DEFINED"
)