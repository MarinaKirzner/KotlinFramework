import core.holder.StaticContextHolder
import core.holder.StaticContextHolder.clearContext
import core.provider.ApplicationConfigProvider
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
abstract class BaseTest {

  @BeforeAll
  fun configContext() {
    StaticContextHolder.applicationConfig = ApplicationConfigProvider().getApplicationConfig()
  }

  @AfterAll
  fun clearUp() {
    clearContext()
  }
}