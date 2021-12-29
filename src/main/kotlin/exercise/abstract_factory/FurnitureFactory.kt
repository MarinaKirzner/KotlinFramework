package exercise.abstract_factory

import exercise.abstract_factory.furniture_type.CreateChair
import exercise.abstract_factory.furniture_type.CreateTable
import exercise.enum.FurnitureType

class FurnitureFactory : FurnitureManager() {

  override fun createFurniture(furnitureType: FurnitureType): String {
    return when (furnitureType) {
      FurnitureType.TABLE -> CreateTable().furniture()
      FurnitureType.CHAIR -> CreateChair().furniture()
    }
  }
}