package factory

import enum.PositionType
import org.junit.jupiter.api.Assertions

import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class PositionFactoryTest {
  @ParameterizedTest
  @EnumSource(PositionType::class)
  fun `Verify description created position type`(positionType: PositionType) {
    val descriptionPositionExpected = "$positionType work with planning and reporting"
    val descriptionPositionActual = PositionManager().creatPositionType(positionType)

    Assertions.assertEquals(descriptionPositionExpected, descriptionPositionActual, "Description is not correct")

  }


}