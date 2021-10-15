package factory

import enum.PositionType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PositionPMFactoryTest {

  @Test
  fun `Verify description created position PM`(){
    val descriptionPositionExpected = "PM work with planning and reporting"
    val descriptionPositionActual = PositionManager().creatPositionType(PositionType.PM)

    Assertions.assertEquals(descriptionPositionExpected, descriptionPositionActual, "Description is not correct")

  }

}