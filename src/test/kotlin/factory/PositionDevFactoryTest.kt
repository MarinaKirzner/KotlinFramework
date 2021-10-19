package factory

import enum.PositionType
import factory.position.PositionDEV
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PositionDevFactoryTest {

  @Test
  fun `Verify description created for position type DEV`() {
    val descriptionPositionExpected = PositionDEV.position
    val descriptionPositionActual = PositionManager().createPositionType(PositionType.DEV)

    assertEquals(descriptionPositionExpected, descriptionPositionActual, "Description is not correct")
  }
}