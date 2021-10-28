package abstract_factory

import enum.FurnitureType

abstract class FurnitureManager {
  abstract fun createFurniture(furnitureType: FurnitureType): String
}