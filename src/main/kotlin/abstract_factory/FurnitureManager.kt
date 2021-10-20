package abstract_factory

import abstract_factory.furniture_type.CreateChair
import abstract_factory.furniture_type.CreateTable
import enum.FurnitureType

abstract class FurnitureManager {
  abstract fun createFurniture(furnitureType: FurnitureType): String
}