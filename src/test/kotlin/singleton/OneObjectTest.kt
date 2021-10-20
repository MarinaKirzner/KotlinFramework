package singleton

import org.junit.jupiter.api.Assertions.assertAll
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OneObjectTest {

  @Test
  fun `Verify OneObject getInstance create only one instance`() {
    val firstObject: OneObject? = OneObject.getInstance()
    val secondObject: OneObject? = OneObject.getInstance()

    assertAll(
      {
        if (firstObject == null || secondObject == null)
          assertEquals(
            firstObject, secondObject, "Objects are equal null"
          )
      },
      {
        assertEquals(
          firstObject, secondObject, "Two difference objects created"
        )
      }
    )
  }
}