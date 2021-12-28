import core.holder.dynamicContext.DynamicContext
import core.holder.dynamicContext.DynamicContextHolder
import core.holder.staticContext.StaticContextHolder
import core.provider.ApplicationConfigProvider
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseTest {

  @BeforeAll
  fun configContext() {
    StaticContextHolder.applicationConfig = ApplicationConfigProvider().getApplicationConfig()
    DynamicContextHolder.dynamicContext = DynamicContext()
  }

  @AfterAll
  fun clearUp() {
    StaticContextHolder.clearContext()
    DynamicContextHolder.clearContext()
  }
}