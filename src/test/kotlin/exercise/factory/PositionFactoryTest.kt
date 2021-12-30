package exercise.factory

import exercise.enum.PositionType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class PositionFactoryTest {

  @ParameterizedTest(name = "Description created for {arguments}")
  @EnumSource(PositionType::class)
  fun `Verify description created for position type`(positionType: PositionType) {
    val descriptionPositionExpected = "$positionType created"
    val descriptionPositionActual = PositionManager().createPositionType(positionType)

    Assertions.assertEquals(descriptionPositionExpected, descriptionPositionActual, "Description is not correct")
  }
}