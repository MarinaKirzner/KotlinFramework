package core.reader

object JsonFileRead {
  fun convertJsonAsString(fileName: String): String? {
    return Thread.currentThread().contextClassLoader.getResourceAsStream(fileName)
      ?.readBytes()?.toString(Charsets.UTF_8)
  }
}