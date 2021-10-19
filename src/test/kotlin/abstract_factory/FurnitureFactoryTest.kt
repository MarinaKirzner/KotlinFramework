package abstract_factory

import enum.FurnitureType
import enum.MaterialType
import org.junit.jupiter.api.Test

class FurnitureFactoryTest {

  @Test
  fun `Verify the created furniture by type and material`(){

   FurnitureFactory().getFurnitureType(FurnitureType.CHAIR).createFurniture()
    FurnitureFactory().getMaterialType(MaterialType.CHIPBOARD).createMaterial()


  }

}