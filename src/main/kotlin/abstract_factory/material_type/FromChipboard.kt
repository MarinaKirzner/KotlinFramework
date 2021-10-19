package abstract_factory.material_type

import abstract_factory.FurnitureFactory

class FromChipboard : CreateMaterial {

  companion object {
    const val chipboard: String = "from Chipboard"
  }

  override fun createMaterial(): String {
    println(chipboard)
    return chipboard
  }
}