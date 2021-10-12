package singleton

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OneObjectTest {

  @Test
  fun `create one object`() {
   val firstObject = OneObject.getInstance()
   val secondObject = OneObject.getInstance()

    assertEquals(firstObject, secondObject)

  }

}