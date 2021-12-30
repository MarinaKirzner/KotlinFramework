package exercise.abstract_factory

import exercise.enum.FurnitureType

abstract class FurnitureManager {
  abstract fun createFurniture(furnitureType: FurnitureType): String
}