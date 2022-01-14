package core.reader

object JsonFileRead {
  fun convertJsonAsString(): String? =
    Thread.currentThread().contextClassLoader.getResourceAsStream("successCrmLoginResponse.json")
      ?.readBytes()?.toString(Charsets.UTF_8)
}