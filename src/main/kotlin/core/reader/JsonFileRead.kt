package core.reader

object JsonFileRead {
  fun convertJsonAsString(fileName: String): String? =
    Thread.currentThread().contextClassLoader.getResourceAsStream(fileName)
      ?.readBytes()?.toString(Charsets.UTF_8)
}