package data_class

import com.sun.xml.internal.ws.developer.Serialization

@Serialization
data class ConfigFile(
  val url: String = "url",
  val login: String = "e-mail",
  val pass: String = "pass"
)