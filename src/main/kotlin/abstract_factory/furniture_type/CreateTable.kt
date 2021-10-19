package abstract_factory.furniture_type

import abstract_factory.material_type.CreateMaterial
import enum.MaterialType

class CreateTable() : Furniture {
   companion object {
    const val table: String = "Table created"
  }

  override fun createFurniture(): String {
    println(table)
    return table
  }

}