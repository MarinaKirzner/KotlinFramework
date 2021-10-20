package abstract_factory.furniture_type

class CreateChair {

  companion object {
    const val chair: String = "CHAIR created"
  }

  fun furniture(): String {
    println(chair)
    return chair
  }
}