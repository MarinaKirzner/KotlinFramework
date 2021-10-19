package abstract_factory.furniture_type

class CreateChair: Furniture {

  companion object {
    const val chair: String = "Chair created"
  }

  override fun createFurniture(): String {
    println(chair)
    return chair
  }
}