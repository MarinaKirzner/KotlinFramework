import core.context.constant.ApplicationConfigProvider
import core.context.constant.StaticContextHolder
import core.context.dynamic.DynamicContext
import core.context.dynamic.DynamicContextHolder
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseTest {

  @BeforeAll
  fun configContext() {
    StaticContextHolder.context = ApplicationConfigProvider().getApplicationConfig()
    DynamicContextHolder.context = DynamicContext()
  }

  @AfterAll
  fun clearUp() {
    StaticContextHolder.clearContext()
    DynamicContextHolder.clearContext()
  }
}