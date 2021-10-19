package abstract_factory

import abstract_factory.furniture_type.CreateChair
import abstract_factory.furniture_type.CreateTable
import abstract_factory.furniture_type.Furniture
import abstract_factory.material_type.CreateMaterial
import abstract_factory.material_type.FromChipboard
import abstract_factory.material_type.FromWood
import enum.FurnitureType
import enum.MaterialType

class FurnitureFactory : AbstractFactory(){

  override fun getFurnitureType(furnitureType: FurnitureType): Furniture {
    return when(furnitureType) {
      FurnitureType.TABLE -> CreateTable()
      FurnitureType.CHAIR -> CreateChair()
    }
  }

  override fun getMaterialType(materialType: MaterialType) : CreateMaterial {
    return when(materialType) {
      MaterialType.WOOD -> FromWood()
      MaterialType.CHIPBOARD -> FromChipboard()
    }
  }


}