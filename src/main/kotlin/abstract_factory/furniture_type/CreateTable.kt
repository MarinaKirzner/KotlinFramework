package abstract_factory.furniture_type

class CreateTable {
  companion object {
    const val table: String = "TABLE created"
  }

  fun furniture(): String {
    println(table)
    return table
  }
}