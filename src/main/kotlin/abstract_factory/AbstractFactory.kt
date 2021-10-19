package abstract_factory
import abstract_factory.furniture_type.Furniture
import abstract_factory.material_type.CreateMaterial
import enum.FurnitureType
import enum.MaterialType

abstract class AbstractFactory(){
  abstract fun getFurnitureType(furnitureType: FurnitureType): Furniture
  abstract fun getMaterialType(materialType: MaterialType): CreateMaterial
}