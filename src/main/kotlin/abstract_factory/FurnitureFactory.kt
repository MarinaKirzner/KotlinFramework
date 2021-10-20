package abstract_factory

import abstract_factory.furniture_type.CreateChair
import abstract_factory.furniture_type.CreateTable
import enum.FurnitureType

class FurnitureFactory : FurnitureManager() {

  override fun createFurniture(furnitureType: FurnitureType): String {
    return when (furnitureType) {
      FurnitureType.TABLE -> CreateTable().furniture()
      FurnitureType.CHAIR -> CreateChair().furniture()
    }
  }
}