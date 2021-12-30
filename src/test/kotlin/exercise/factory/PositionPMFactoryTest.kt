package exercise.factory

import exercise.enum.PositionType
import exercise.factory.position.PositionPM
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PositionPMFactoryTest {

  @Test
  fun `Verify description created for position type PM`() {
    val descriptionPositionExpected = PositionPM.position
    val descriptionPositionActual = PositionManager().createPositionType(PositionType.PM)

    assertEquals(descriptionPositionExpected, descriptionPositionActual, "Description is not correct")
  }
}