package factory

import enum.PositionType
import org.junit.jupiter.api.Test

class PositionFactoryTest {

  @Test
  fun `Verify description created position type`(){
    PositionManager().creatPositionType(PositionType.QA)
    PositionManager().creatPositionType(PositionType.DEV)
    PositionManager().creatPositionType(PositionType.PM)
  }


}