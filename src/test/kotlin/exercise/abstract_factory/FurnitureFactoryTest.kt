package exercise.abstract_factory

import exercise.enum.FurnitureType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class FurnitureFactoryTest {

  @ParameterizedTest(name = "Verify furniture creation {arguments}")
  @EnumSource(FurnitureType::class)
  fun `Verify the created furniture type`(furnitureType: FurnitureType) {
    val furnitureExpected = "$furnitureType created"
    val furnitureActual = FurnitureFactory().createFurniture(furnitureType)

    Assertions.assertEquals(furnitureExpected, furnitureActual, "Description is not correct")
  }
}