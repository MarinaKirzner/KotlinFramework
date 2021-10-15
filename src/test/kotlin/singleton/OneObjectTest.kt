package singleton
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OneObjectTest {

  @Test
  fun `Verify OneObject getInstance create only one instance`() {
   val firstObject : OneObject? = OneObject.getInstance()
   val secondObject : OneObject? = OneObject.getInstance()

    assertEquals(firstObject, secondObject, "Создается больше одного объекта")

  }

}