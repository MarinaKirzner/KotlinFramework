package exercise.factory

import exercise.enum.PositionType
import exercise.factory.position.PositionQA
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PositionQAFactoryTest {

  @Test
  fun `Verify description created for position type QA`() {
    val descriptionPositionExpected = PositionQA.position
    val descriptionPositionActual = PositionManager().createPositionType(PositionType.QA)

    assertEquals(descriptionPositionExpected, descriptionPositionActual, "Description is not correct")
  }
}