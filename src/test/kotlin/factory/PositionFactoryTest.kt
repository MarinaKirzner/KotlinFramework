package factory

import enum.PositionType
import org.junit.jupiter.api.Test

class PositionFactoryTest {

  @Test
  fun `Verify `(){
    PositionManager().creatPositionType(PositionType.QA)
    PositionManager().creatPositionType(PositionType.DEV)
    PositionManager().creatPositionType(PositionType.PM)
  }


}