package factory

import enum.PositionType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class PositionDevFactoryTest {

  @Test
  fun `Verify description created position DEV`(){
    val descriptionPositionExpected = "DEV work with planning and reporting"
    val descriptionPositionActual = PositionManager().creatPositionType(PositionType.DEV)

    Assertions.assertEquals(descriptionPositionExpected, descriptionPositionActual, "Description is not correct")

  }

}