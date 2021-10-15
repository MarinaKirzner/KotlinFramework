package factory

import enum.PositionType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PositionQAFactoryTest {

  @Test
  fun `Verify description created position QA`(){
    val descriptionPositionExpected = "QA work with planning and reporting"
    val descriptionPositionActual = PositionManager().creatPositionType(PositionType.QA)

    assertEquals(descriptionPositionExpected, descriptionPositionActual, "Description is not correct")

  }


}