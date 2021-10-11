import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TestOneObjectCreated {

  @Test
  fun 'create one object'() {
   val firstObject = OneObject.getInstance()
   val secondObject = OneObject.getInstance()

    assertEquals(firstObject, secondObject)

  }

}